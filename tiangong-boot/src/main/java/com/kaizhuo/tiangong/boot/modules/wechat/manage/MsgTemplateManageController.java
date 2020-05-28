package com.kaizhuo.tiangong.boot.modules.wechat.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.MsgTemplate;
import com.kaizhuo.tiangong.boot.modules.wechat.form.TemplateMsgBatchForm;
import com.kaizhuo.tiangong.boot.modules.wechat.service.MsgTemplateService;
import com.kaizhuo.tiangong.boot.modules.wechat.service.TemplateMsgService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 消息模板
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2019-11-12 18:30:15
 */
@RestController
@RequestMapping("/v1/manager/msgTemplate")
public class MsgTemplateManageController extends BaseController<MsgTemplateService, MsgTemplate> {

    @Autowired
    private TemplateMsgService templateMsgService;

    /**
     * 信息
     */
    @GetMapping("/getByName")
    @RequiresPermissions("wx:msgtemplate:info")
    public ResponseVo<MsgTemplate> getByName(String name) {
        MsgTemplate msgTemplate = bizService.selectByName(name);

        return new ResponseVo<>(msgTemplate);
    }


    /**
     * 同步公众号模板
     */
    @PostMapping("/syncWxTemplate")
    @RequiresPermissions("wx:msgtemplate:save")
    public ResponseVo syncWxTemplate() throws WxErrorException {
        bizService.syncWxTemplate();
        return ResponseVo.ok();
    }

    /**
     * 批量向用户发送模板消息
     * 通过用户筛选条件（一般使用标签筛选），将消息发送给数据库中所有符合筛选条件的用户
     */
    @PostMapping("/sendMsgBatch")
    @RequiresPermissions("wx:msgtemplate:save")
    public ResponseVo sendMsgBatch(@RequestBody TemplateMsgBatchForm form) throws WxErrorException {
        templateMsgService.sendMsgBatch(form);
        return ResponseVo.ok();
    }


}
