package com.kaizhuo.tiangong.boot.module.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.core.util.ConvertUtil;
import com.kaizhuo.tiangong.boot.core.util.Md5Util;
import com.kaizhuo.tiangong.boot.core.util.NetworkUtils;
import com.kaizhuo.tiangong.boot.security.jwt.TiangongJwt;
import com.kaizhuo.tiangong.boot.module.user.constants.AuthConstants;
import com.kaizhuo.tiangong.boot.module.user.constants.CoreConstant;
import com.kaizhuo.tiangong.boot.module.user.constants.UserErrorCode;
import com.kaizhuo.tiangong.boot.module.user.entity.*;
import com.kaizhuo.tiangong.boot.module.user.exception.UserException;
import com.kaizhuo.tiangong.boot.module.user.mapper.UserMapper;
import com.kaizhuo.tiangong.boot.module.user.service.*;
import com.kaizhuo.tiangong.boot.module.user.vo.request.*;
import com.kaizhuo.tiangong.boot.module.user.vo.response.LoginResponseVo;
import com.kaizhuo.tiangong.boot.module.user.vo.response.UserAuthCache;
import com.kaizhuo.tiangong.boot.module.user.vo.response.UserResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:58
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private UserRoleMappingService userRoleMappingService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private UserDeptMappingService userDeptMappingService;
    @Autowired
    private PostService postService;
    @Autowired
    private UserPostMappingService userPostMappingService;

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private TiangongJwt tiangongJwt;

    @Override
    public User findByUserName(String userName) {
        return baseMapper.findByUserName(userName);
    }

    @Override
    public LoginResponseVo login(UserAccountVo accountVo) {
        String userName=accountVo.getUserName();
        String password=accountVo.getPassword().toLowerCase();
        User user=findByUserName(userName);
        if(user==null){
            throw new UserException(UserErrorCode.USER_OR_PASSWORD_ERROR.getCode());
        }

        Long userId=user.getUserId();
        if(CoreConstant.USER_LOCK.equals(user.getUserStatus())){
            throw new UserException(UserErrorCode.USER_LOCK_ERROR.getCode());
        }

        //加盐校验密码
        String verifyPassword= Md5Util.createSaltMd5(password);
        String dbPassword = user.getPassword();
        if (!verifyPassword.equals(dbPassword)) {
            throw new UserException(UserErrorCode.USER_OR_PASSWORD_ERROR.getCode());
        }
        // 填充用户信息
        LoginResponseVo loginResponseVo = new LoginResponseVo();
        UserResponseVo userInfo = getUserInfo(userId);

        loginResponseVo.setUserInfo(userInfo);

        // 更新最后登录时间
        user.setLastLogin(new Date());
        updateById(user);

        // 暂时写死鉴权类型为WEB
        loginResponseVo.setUserToken(tiangongJwt.createToken(userId,1));

        // 记录登录日志
        LoginLog loginLog = new LoginLog();
        loginLog.setDevice(AuthConstants.AUTH_TYPE_WEB);
        loginLog.setLoginTime(new Date());
        loginLog.setLoginUserId(userId);
        loginLog.setLoginUserName(userName);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setLoginIp(NetworkUtils.getIpAddr(request));
        loginLogService.save(loginLog);
        return loginResponseVo;
    }

    @Override
    public void logout(Long userId) {
        //TODO
    }

    @Override
    public void updateUserInfo(Long userId, UserInfoVo infoVo) {
        User userInfo = getById(userId);
        if(userInfo == null){
            throw new UserException(UserErrorCode.USER_NOT_EXIST_ERROR.getCode());
        }

        User user = new User();
        user.setUserId(userId);
        BeanUtils.copyProperties(infoVo, user);

        String userRoles = infoVo.getUserRoles();
        String userDepts = infoVo.getUserDepts();
        String userPosts = infoVo.getUserPosts();
        bindRoleDeptPost(userId, userRoles, userDepts, userPosts);

        updateById(user);
    }

    @Override
    public void updateUserPwd(UserPwdVo userPwdVo) {
        Long userId = userPwdVo.getUserId();
        String password = userPwdVo.getPassword();

        User userInfo = getById(userId);
        if(userInfo == null){
            throw new UserException(UserErrorCode.USER_NOT_EXIST_ERROR.getCode());
        }

        User user = new User();
        user.setUserId(userId);

        String saltMd5 = Md5Util.createSaltMd5(password);
        user.setPassword(saltMd5);

        updateById(user);
    }

    @Override
    @Transactional
    public void addUser(AddUserVo userVo) {
        User userFindByName = findByUserName(userVo.getUserName());
        if(userFindByName != null){
            throw new UserException(UserErrorCode.USER_NAME_EXIST_ERROR.getCode());
        }

        User user = new User();
        BeanUtils.copyProperties(userVo, user);

        String password = userVo.getPassword();
        String saltMd5 = Md5Util.createSaltMd5(password);
        user.setPassword(saltMd5);
        user.setJoinTime(new Date());
        save(user);

        Long userId = user.getUserId();
        String userRoles = userVo.getUserRoles();
        String userDepts = userVo.getUserDepts();
        String userPosts = userVo.getUserPosts();
        bindRoleDeptPost(userId, userRoles, userDepts, userPosts);
    }

    @Override
    public UserResponseVo getUserInfo(Long userId) {
        User user = getById(userId);
        if (user == null || Constants.DELETE_CODE_YES.equals(user.getIsDel())) {
            throw new UserException(UserErrorCode.USER_NOT_EXIST_ERROR.getCode());
        }

        UserResponseVo userInfo = new UserResponseVo();
        BeanUtils.copyProperties(user, userInfo);

        List<Role> userRoles = roleService.getUserRoles(userId);

        List<Dept> userDepts = deptService.getUserDepts(userId);

        List<Post> userPosts = postService.getUserPosts(userId);

        userInfo.setUserRoles(userRoles);
        userInfo.setUserDepts(userDepts);
        userInfo.setUserPosts(userPosts);

        return userInfo;
    }

    @Override
    public IPage<UserResponseVo> getUserList(UserFilterVo filterVo) {
        // 部门ID不为空,则获取该部门ID及所有子类部门ID
        Long deptId = filterVo.getDeptId();
        if(deptId != null && deptId != 0){
            List<Long> deptIds = deptService.getDeptIdsByParentId(deptId);
            deptIds.add(deptId);

            filterVo.setAllDeptIds(deptIds);
        }

        return baseMapper.getUserList(convertPageParam(filterVo), filterVo);
    }

    @Override
    public List<User> getUserByGroup(Long groupId) {
        return baseMapper.getUserByGroupId(groupId);
    }

    @Override
    @Transactional
    public void removeByUserId(Long userId) {
        User user = getById(userId);
        if(user == null){
            throw new UserException(UserErrorCode.USER_NOT_EXIST_ERROR.getCode());
        }

        if(Constants.ADMIN_NAME.equals(user.getUserName())){
            throw new UserException(UserErrorCode.ADMIN_USER_CANNOT_DELETE_ERROR.getCode());
        }

        unbindRoleDeptPost(userId);
        removeById(userId);
    }

    @Override
    public void bindRoleDeptPost(Long userId, String userRoles, String userDepts, String userPosts) {
        List<Long> roleIdList = ConvertUtil.splitStr2LongList(userRoles, ",");
        List<Long> deptIdList = ConvertUtil.splitStr2LongList(userDepts, ",");
        List<Long> postIdList = ConvertUtil.splitStr2LongList(userPosts, ",");

        roleService.bindUserRole(userId, roleIdList);
        deptService.bindUserDept(userId, deptIdList);
        postService.bindUserPost(userId, postIdList);
    }

    @Override
    public void unbindRoleDeptPost(Long userId) {
        userRoleMappingService.removeByUserId(userId);
        userDeptMappingService.removeByUserId(userId);
        userPostMappingService.removeByUserId(userId);
    }

    @Override
    public void refreshUserAuthCache(Long userId) {

    }

    @Override
    public UserAuthCache getUserAuthCache(Long userId) {
        return null;
    }


}
