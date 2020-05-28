package com.kaizhuo.tiangong.boot.modules.wechat.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.MsgReplyRule;
import com.kaizhuo.tiangong.boot.modules.wechat.service.MsgReplyRuleService;
import org.springframework.web.bind.annotation.*;


/**
 * 自动回复规则
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2019-11-12 18:30:15
 */
@RestController
@RequestMapping("/v1/manager/msgReplyRule")
public class MsgReplyRuleManageController extends BaseController<MsgReplyRuleService,MsgReplyRule> {


}
