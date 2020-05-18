package com.kaizhuo.tiangonguser.controller;

import com.kaizhuo.common.core.base.controller.BaseController;
import com.kaizhuo.common.core.util.ConvertUtil;
import com.kaizhuo.common.core.vo.ResponseVo;
import com.kaizhuo.tiangonguser.constants.Urls;
import com.kaizhuo.tiangonguser.entity.Dept;
import com.kaizhuo.tiangonguser.service.DeptService;
import com.kaizhuo.tiangonguser.vo.response.DeptVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.controller
 * @description: 部门信息
 * @author: miaochen
 * @create: 2020-05-17 21:49
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT + "dept")
@Api(value = "部门信息相关", tags = "部门信息相关")
@PreAuthorize("isAuthenticated()")
public class DeptController extends BaseController<DeptService, Dept> {

    @GetMapping(value = "/list")
    @ApiOperation(value = "获取树状结构部门列表", notes = "获取树状结构部门列表")
    public ResponseVo<List<DeptVo>> getDepts() {
        List<DeptVo> treeDepts = bizService.getTreeDepts();
        return new ResponseVo<>(treeDepts);
    }

    @GetMapping(value = "/{userId}/list")
    @ApiOperation(value = "获取指定用户的部门列表", tags = "获取指定用户的部门列表")
    public ResponseVo<List<Dept>> getUserRoles(@PathVariable("userId") Long userId) {
        List<Dept> userDepts = bizService.getUserDepts(userId);
        return new ResponseVo<>(userDepts);
    }

    @PutMapping("/bind/{userId}")
    @ApiOperation(value = "设置用户所属部门", notes = "设置用户所属部门")
    public ResponseVo userDeptBind(@PathVariable("userId") Long userId, @ApiParam(value = "所属的部门ID,多个以英文逗号分隔", required = true) @RequestParam(value = "deptIds") String deptIds){
        List<Long> deptIdList= ConvertUtil.splitStr2LongList(deptIds,",");
        bizService.bindUserDept(userId,deptIdList);
        return new ResponseVo();
    }
}
