package com.kaizhuo.tiangong.boot.admin.rest;


import com.kaizhuo.tiangong.boot.admin.constants.Urls;
import com.kaizhuo.tiangong.boot.common.util.ConvertUtil;
import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.support.core.entity.UserGroup;
import com.kaizhuo.tiangong.boot.support.core.service.IUserGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/userGroup")
@Api(value = "用户组相关", tags = "用户组相关")
public class UserGroupController extends BaseController<IUserGroupService, UserGroup> {

    @RequestMapping(value = Urls.USER_GROUP_BIND, method = RequestMethod.PUT)
    @ApiOperation(value = "绑定组内用户,多个以逗号分隔", notes = "绑定组内用户,多个以逗号分隔")
    @ResponseBody
    public ResponseVo bindUsers(@PathVariable Long groupId, @RequestParam(value = "userIds") String userIds) {
        List<Long> userIdList = ConvertUtil.splitStr2LongList(userIds, ",");
        bizService.bindUsers(groupId, userIdList);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.USER_GROUP_ROLE_BIND, method = RequestMethod.PUT)
    @ApiOperation(value = "绑定用户组对应的角色,多个以逗号分隔", notes = "绑定用户组对应的角色,多个以逗号分隔")
    @ResponseBody
    public ResponseVo bindRoles(@PathVariable Long groupId, @RequestParam(value = "roleIds") String roleIds) {
        List<Long> roleIdList = ConvertUtil.splitStr2LongList(roleIds, ",");
        bizService.bindRoles(groupId, roleIdList);
        return new ResponseVo();
    }
}

