package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wx.entity.MsgTemplate;
import com.kaizhuo.tiangong.boot.modules.wx.form.TemplateMsgBatchForm;
import com.kaizhuo.tiangong.boot.modules.wx.service.MsgTemplateService;
import com.kaizhuo.tiangong.boot.modules.wx.service.TemplateMsgService;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 消息模板
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2019-11-12 18:30:15
 */
@RestController
@RequestMapping("/manage/msgTemplate")
public class MsgTemplateManageController {
    @Autowired
    private MsgTemplateService msgTemplateService;
    @Autowired
    private TemplateMsgService templateMsgService;

//    /**
//     * 列表
//     */
//    @GetMapping("/list")
//    @RequiresPermissions("wx:msgtemplate:list")
//    public R list(@RequestParam Map<String, Object> params) {
//        PageUtils page = msgTemplateService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("wx:msgtemplate:info")
    public ResponseVo<MsgTemplate> info(@PathVariable("id") Long id) {
        MsgTemplate msgTemplate = msgTemplateService.getById(id);

        return new ResponseVo<>(msgTemplate);
    }

    /**
     * 信息
     */
    @GetMapping("/getByName")
    @RequiresPermissions("wx:msgtemplate:info")
    public ResponseVo<MsgTemplate> getByName(String name) {
        MsgTemplate msgTemplate = msgTemplateService.selectByName(name);

        return new ResponseVo<>(msgTemplate);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("wx:msgtemplate:save")
    public ResponseVo save(@RequestBody MsgTemplate msgTemplate) {
        msgTemplateService.save(msgTemplate);

        return ResponseVo.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("wx:msgtemplate:update")
    public ResponseVo update(@RequestBody MsgTemplate msgTemplate) {
        msgTemplateService.updateById(msgTemplate);

        return ResponseVo.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("wx:msgtemplate:delete")
    public ResponseVo delete(@RequestBody String[] ids) {
        msgTemplateService.removeByIds(Arrays.asList(ids));

        return ResponseVo.ok();
    }

    /**
     * 同步公众号模板
     */
    @PostMapping("/syncWxTemplate")
    @RequiresPermissions("wx:msgtemplate:save")
    public ResponseVo syncWxTemplate() throws WxErrorException {
        msgTemplateService.syncWxTemplate();
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
