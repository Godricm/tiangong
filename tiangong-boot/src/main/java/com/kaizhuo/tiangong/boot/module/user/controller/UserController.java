package com.kaizhuo.tiangong.boot.module.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.kaizhuo.tiangong.boot.module.user.constants.Urls;
import com.kaizhuo.tiangong.boot.module.user.entity.User;
import com.kaizhuo.tiangong.boot.module.user.service.UserService;
import com.kaizhuo.tiangong.boot.module.user.vo.request.*;
import com.kaizhuo.tiangong.boot.module.user.vo.response.LoginResponseVo;
import com.kaizhuo.tiangong.boot.module.user.vo.response.UserResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.controller
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

    @PutMapping("/login")
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

    @PutMapping("logout")
    @ApiOperation(value = "用户注销", notes = "用户注销")
    public ResponseVo<LoginResponseVo> logout(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        userService.logout(userId);

        return new ResponseVo<>();
    }

    @PostMapping(value = "")
    @ApiOperation(value = "新增用户", notes = "新增用户")
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

    @PutMapping("/{userId}")
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    public ResponseVo updateUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId, UserInfoVo infoVo) {
        userService.updateUserInfo(userId, infoVo);
        return new ResponseVo();
    }

    @PutMapping(value = "/rest")
    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    public ResponseVo updateUserPwd(UserPwdVo userPwdVo) {
        userService.updateUserPwd(userPwdVo);
        return new ResponseVo();
    }

    @GetMapping(value = "/page")
    @ApiOperation(value = "分页获取用户列表", notes = "分页获取用户列表")
    public ResponseVo<IPage<UserResponseVo>> getUser(UserFilterVo filterVo) {
        return new ResponseVo<>(userService.getUserList(filterVo));
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取用户列表", notes = "分页获取用户列表")
    public ResponseVo<List<User>> getAllUser(User user) {
        return new ResponseVo<>(userService.list(new QueryWrapper<>(user)));
    }

    @RequestMapping(value = "/group/{groupId}/list", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户组关联用户", notes = "获取用户组关联用户")
    public ResponseVo<List<User>> getUserByGroup(@PathVariable("groupId") Long groupId) {
        return new ResponseVo<>(userService.getUserByGroup(groupId));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public ResponseVo<UserResponseVo> getUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        return new ResponseVo<>(userService.getUserInfo(userId));
    }

    @DeleteMapping(value = "/{userId}")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public ResponseVo deleteUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        userService.removeByUserId(userId);
        return new ResponseVo<>();
    }

    @RequestMapping(value = "/lock/{userId}", method = RequestMethod.PUT)
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
