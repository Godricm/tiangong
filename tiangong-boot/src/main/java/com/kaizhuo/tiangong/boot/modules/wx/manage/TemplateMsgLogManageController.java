package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.wx.entity.TemplateMsgLog;
import com.kaizhuo.tiangong.boot.modules.wx.service.TemplateMsgLogService;
import org.springframework.web.bind.annotation.*;


/**
 * 模版消息发送记录
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2019-11-12 18:30:15
 */
@RestController
@RequestMapping("/manage/templateMsgLog")
public class TemplateMsgLogManageController extends BaseController<TemplateMsgLogService,TemplateMsgLog> {


}
