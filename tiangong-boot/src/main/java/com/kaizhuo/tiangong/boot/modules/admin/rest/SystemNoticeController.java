package com.kaizhuo.tiangong.boot.modules.admin.rest;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaizhuo.tiangong.boot.framework.constants.Constants;
import com.kaizhuo.tiangong.boot.framework.constants.Urls;
import com.kaizhuo.tiangong.boot.framework.vo.PageRequest;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.admin.entity.SystemNotice;
import com.kaizhuo.tiangong.boot.modules.admin.entity.User;
import com.kaizhuo.tiangong.boot.modules.admin.service.ISystemNoticeService;
import com.kaizhuo.tiangong.boot.modules.admin.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(com.kaizhuo.tiangong.boot.modules.admin.constants.Urls.ROOT+"/systemNotice")
@Api(value = "系统公告相关", tags = "系统公告相关")
public class SystemNoticeController {

    @Autowired
    protected ISystemNoticeService bizService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = Urls.BASE_ADD, method = RequestMethod.POST)
    @ApiOperation(value = "(自动生成)添加", notes = "添加")
    @ResponseBody
    public ResponseVo add(@RequestHeader(Constants.HEADER_USER_ID) Long userId, SystemNotice entity) {
        if(userId != null){
            User userInfo = userService.getById(userId);
            entity.setPublishId(userId);
            entity.setPublishName(userInfo.getUserName());
        }
        entity.setPublishTime(new Date());

        bizService.save(entity);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.BASE_GET, method = RequestMethod.GET)
    @ApiOperation(value = "(自动生成)根据id获取数据", notes = "根据id获取数据")
    @ResponseBody
    public ResponseVo<SystemNotice> get(@PathVariable Serializable id) {
        return new ResponseVo<>(bizService.getById(id));
    }

    @RequestMapping(value = Urls.BASE_UPDATE, method = RequestMethod.PUT)
    @ApiOperation(value = "(自动生成)根据id更新数据", notes = "根据id更新数据")
    @ResponseBody
    public ResponseVo update(SystemNotice entity) {
        bizService.updateById(entity);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.BASE_DELETE, method = RequestMethod.DELETE)
    @ApiOperation(value = "(自动生成)根据id删除数据", notes = "根据id删除数据")
    @ResponseBody
    public ResponseVo remove(@PathVariable Serializable id) {
        bizService.removeById(id);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.BASE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "(自动生成)获取列表", notes = "获取列表")
    @ResponseBody
    public ResponseVo<List<SystemNotice>> all(SystemNotice entity) {
        return new ResponseVo<>(bizService.list(new QueryWrapper<>(entity)));
    }

    @RequestMapping(value = Urls.BASE_PAGE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "(自动生成)分页获取列表", notes = "分页获取列表")
    @ResponseBody
    public ResponseVo<IPage<SystemNotice>> list(PageRequest pageRequest, SystemNotice entity) {
        //查询列表数据
        IPage<SystemNotice> page = bizService.page(
                new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize()),
                new QueryWrapper<>(entity)
        );

        return new ResponseVo<>(page);
    }
}

