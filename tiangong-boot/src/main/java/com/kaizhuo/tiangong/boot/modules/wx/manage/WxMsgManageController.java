package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wx.entity.WxMsg;
import com.kaizhuo.tiangong.boot.modules.wx.form.WxMsgReplyForm;
import com.kaizhuo.tiangong.boot.modules.wx.service.MsgReplyService;
import com.kaizhuo.tiangong.boot.modules.wx.service.WxMsgService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 微信消息
 *
 * @author niefy
 * @date 2020-05-14 17:28:34
 */
@RestController
@RequestMapping("/manage/wxMsg")
public class WxMsgManageController  extends BaseController<WxMsgService, WxMsg> {

    @Autowired
    private MsgReplyService msgReplyService;

    /**
     * 回复
     */
    @PostMapping("/reply")
    @RequiresPermissions("wx:wxmsg:save")
    public ResponseVo reply(@RequestBody WxMsgReplyForm form){

        msgReplyService.reply(form.getOpenid(),form.getReplyType(),form.getReplyContent());
        return ResponseVo.ok();
    }

}
