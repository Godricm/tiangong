package com.kaizhuo.tiangong.boot.support.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.User;
import com.kaizhuo.tiangong.boot.support.core.vo.request.*;
import com.kaizhuo.tiangong.boot.support.core.vo.response.LoginResponseVo;
import com.kaizhuo.tiangong.boot.support.core.vo.response.UserAuthCache;
import com.kaizhuo.tiangong.boot.support.core.vo.response.UserResponseVo;

import java.util.List;

public interface IUserService extends BaseService<User> {
    User findByUserName(String userName);

    LoginResponseVo login(UserAccountVo accountVo);

    void logout(Long userId);

    void updateUserInfo(Long userId, UserInfoVo infoVo);

    void updateUserPwd(UserPwdVo userPwdVo);

    void addUser(AddUserVo userVo);

    UserResponseVo getUserInfo(Long userId);

    IPage<UserResponseVo> getUserList(UserFilterVo filterVo);

    List<User> getUserByGroup(Long groupId);

    void removeByUserId(Long userId);

    void bindRoleDeptPost(Long userId, String userRoles, String userDepts, String userPosts);

    void unbindRoleDeptPost(Long userId);

    void refreshUserAuthCache(Long userId);

    UserAuthCache getUserAuthCache(Long userId);
}
