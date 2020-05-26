package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wx.entity.WxUser;
import com.kaizhuo.tiangong.boot.modules.wx.service.WxUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 用户表
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2020-03-07 13:55:23
 */
@RestController
@RequestMapping("/manage/wxUser")
public class WxUserManageController extends BaseController<WxUserService, WxUser> {



    /**
     * 列表
     */
    @PostMapping("/listByIds")
    @RequiresPermissions("wx:wxuser:list")
    public ResponseVo<List<WxUser>> listByIds(@RequestBody String[] openids){
        List<WxUser> users = bizService.listByIds(Arrays.asList(openids));
        return new ResponseVo<>(users);
    }

    /**
     * 同步用户列表
     */
    @PostMapping("/syncWxUsers")
    @RequiresPermissions("wx:wxuser:save")
    public ResponseVo syncWxUsers() {
        bizService.syncWxUsers();

        return ResponseVo.ok();
    }
}
