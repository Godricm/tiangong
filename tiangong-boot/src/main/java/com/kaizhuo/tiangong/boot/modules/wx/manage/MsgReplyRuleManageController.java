package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.wx.entity.MsgReplyRule;
import com.kaizhuo.tiangong.boot.modules.wx.service.MsgReplyRuleService;
import org.springframework.web.bind.annotation.*;


/**
 * 自动回复规则
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2019-11-12 18:30:15
 */
@RestController
@RequestMapping("/wx/msgReplyRule")
public class MsgReplyRuleManageController extends BaseController<MsgReplyRuleService,MsgReplyRule> {


}
