package com.kaizhuo.tiangonguser.controller;

import com.kaizhuo.tiangonguser.constants.Urls;
import com.kaizhuo.tiangonguser.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.controller
 * @description:
 * @author: miaochen
 * @create: 2020-05-18 22:18
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT+"user")
@Api(value = "用户相关", tags = "用户相关")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = Urls.USER_LOGIN, method = RequestMethod.PUT)
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @SentinelResource(value = "login", blockHandler = "sentinelLogin")
    public ResponseVo<LoginResponseVo> login(@Valid UserAccountVo accountVo) {
        // 校验参数
        if(StringUtils.isEmpty(accountVo.getUserName())){
            throw new UserException(UserErrorCode.USER_NAME_EMPTY_ERROR.getCode());
        }

        if(StringUtils.isEmpty(accountVo.getPassword())){
            throw new UserException(UserErrorCode.USER_PASSWORD_EMPTY_ERROR.getCode());
        }

        return new ResponseVo<>(userService.login(accountVo));
    }

    public ResponseVo<LoginResponseVo> sentinelLogin(UserAccountVo accountVo, BlockException blockException){
        return new ResponseVo<>(CoreErrorCode.SENTINEL_ERROR.getCode(), CoreErrorCode.SENTINEL_ERROR.getDesc());
    }

    @RequestMapping(value = Urls.USER_LOGOUT, method = RequestMethod.PUT)
    @ApiOperation(value = "用户注销", notes = "用户注销")
    @OpLog(description = "用户注销", opType = OpType.OTHER)
    public ResponseVo<LoginResponseVo> logout(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        userService.logout(userId);

        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.USER_ADD, method = RequestMethod.POST)
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @OpLog(description = "添加用户", opType = OpType.INSERT)
    public ResponseVo addUser(AddUserVo user) {
        // 校验参数
        if(StringUtils.isEmpty(user.getUserName())){
            throw new UserException(UserErrorCode.USER_NAME_EMPTY_ERROR.getCode());
        }

        if(StringUtils.isEmpty(user.getPassword())){
            throw new UserException(UserErrorCode.USER_PASSWORD_EMPTY_ERROR.getCode());
        }

        userService.addUser(user);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.USER_UPDATE, method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @OpLog(description = "编辑用户信息", opType = OpType.EDIT)
    public ResponseVo updateUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId, UserInfoVo infoVo) {
        userService.updateUserInfo(userId, infoVo);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.USER_RESET_PWD, method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    @OpLog(description = "修改用户密码", opType = OpType.EDIT)
    public ResponseVo updateUserPwd(UserPwdVo userPwdVo) {
        userService.updateUserPwd(userPwdVo);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.USER_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "分页获取用户列表", notes = "分页获取用户列表")
    public ResponseVo<IPage<UserResponseVo>> getUser(UserFilterVo filterVo) {
        return new ResponseVo<>(userService.getUserList(filterVo));
    }

    @RequestMapping(value = Urls.USER_ALL, method = RequestMethod.GET)
    @ApiOperation(value = "分页获取用户列表", notes = "分页获取用户列表")
    public ResponseVo<List<User>> getAllUser(User user) {
        return new ResponseVo<>(userService.list(new QueryWrapper<>(user)));
    }

    @RequestMapping(value = Urls.USER_LIST_BY_GROUP, method = RequestMethod.GET)
    @ApiOperation(value = "获取用户组关联用户", notes = "获取用户组关联用户")
    public ResponseVo<List<User>> getUserByGroup(@PathVariable("groupId") Long groupId) {
        return new ResponseVo<>(userService.getUserByGroup(groupId));
    }

    @RequestMapping(value = Urls.USER_INFO, method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public ResponseVo<UserResponseVo> getUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        return new ResponseVo<>(userService.getUserInfo(userId));
    }

    @RequestMapping(value = Urls.USER_DELETE, method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @OpLog(description = "删除用户", opType = OpType.DEL)
    public ResponseVo deleteUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        userService.removeByUserId(userId);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.USER_CHANGE_LOCK, method = RequestMethod.PUT)
    @ApiOperation(value = "冻结/解冻用户", notes = "冻结/解冻用户")
    public ResponseVo deleteUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId,
                                 @ApiParam(value = "用户状态 'N' 正常 'L' 锁定", required = true) @RequestParam("userStatus") String userStatus) {
        if(CoreConstants.USER_LOCK.equals(userStatus) || CoreConstants.USER_NONE.equals(userStatus)){
            User user = new User();
            user.setUserId(userId);
            user.setUserStatus(userStatus);
            userService.updateById(user);
            return new ResponseVo<>();
        }else{
            throw new BaseException(CoreErrorCode.PARAM_ERROR.getCode());
        }
    }

    @RequestMapping(value = Urls.USER_AUTH_CACHE, method = RequestMethod.PUT)
    @ApiOperation(value = "刷新用户权限相关缓存(角色、权限)", notes = "刷新用户权限相关缓存(角色、权限)")
    public ResponseVo refreshUserAuthCache(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        userService.refreshUserAuthCache(userId);
        return new ResponseVo();
    }
}
