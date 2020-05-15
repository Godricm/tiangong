package com.kaizhuo.tiangonguser.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.common.core.base.service.BaseService;
import com.kaizhuo.tiangonguser.entity.User;
import com.kaizhuo.tiangonguser.vo.request.*;
import com.kaizhuo.tiangonguser.vo.response.LoginResponseVo;
import com.kaizhuo.tiangonguser.vo.response.UserAuthCache;
import com.kaizhuo.tiangonguser.vo.response.UserResponseVo;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service
 * @description: 用户服务
 * @author: miaochen
 * @create: 2020-05-15 23:22
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserService extends BaseService<User> {
    /**
     * 通过用户名查找
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 登录
     * @param accountVo
     * @return
     */
    LoginResponseVo login(UserAccountVo accountVo);

    /**
     * 登出
     * @param userId
     */
    void logout(Long userId);

    /**
     * 通过用户id更新用户信息
     * @param userId
     * @param infoVo
     */
    void updateUserInfo(Long userId, UserInfoVo infoVo);

    /**
     * 更新密码
     * @param userPwdVo
     */
    void updateUserPwd(UserPwdVo userPwdVo);

    /**
     * 新增用户
     * @param userVo
     */
    void addUser(AddUserVo userVo);

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    UserResponseVo getUserInfo(Long userId);

    /**
     * 获取用户list
     * @param filterVo
     * @return
     */
    IPage<UserResponseVo> getUserList(UserFilterVo filterVo);

    /**
     * 获取用户组下的用户
     * @param groupId
     * @return
     */
    List<User> getUserByGroup(Long groupId);

    /**
     * 删除用户
     * @param userId
     */
    void removeByUserId(Long userId);

    /**
     * 绑定用户角色、部门、岗位
     * @param userId
     * @param userRoles
     * @param userDepts
     * @param userPosts
     */
    void bindRoleDeptPost(Long userId, String userRoles, String userDepts, String userPosts);

    /**
     * 解绑用户角色、部门、岗位
     * @param userId
     */
    void unbindRoleDeptPost(Long userId);

    /**
     * 刷新用户授权信息
     * @param userId
     */
    void refreshUserAuthCache(Long userId);

    /**
     * 获取用户授权信息
     * @param userId
     * @return
     */
    UserAuthCache getUserAuthCache(Long userId);
}
