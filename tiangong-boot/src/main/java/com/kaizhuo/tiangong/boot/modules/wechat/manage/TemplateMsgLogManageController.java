package com.kaizhuo.tiangong.boot.modules.wechat.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.TemplateMsgLog;
import com.kaizhuo.tiangong.boot.modules.wechat.service.TemplateMsgLogService;
import org.springframework.web.bind.annotation.*;


/**
 * 模版消息发送记录
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2019-11-12 18:30:15
 */
@RestController
@RequestMapping("/v1/manager/templateMsgLog")
public class TemplateMsgLogManageController extends BaseController<TemplateMsgLogService,TemplateMsgLog> {


}
