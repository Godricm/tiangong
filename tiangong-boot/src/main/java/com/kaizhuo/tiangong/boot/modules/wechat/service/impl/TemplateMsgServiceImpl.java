package com.kaizhuo.tiangong.boot.modules.wechat.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.framework.config.TaskExcutor;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.TemplateMsgLog;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxUser;
import com.kaizhuo.tiangong.boot.modules.wechat.form.TemplateMsgBatchForm;
import com.kaizhuo.tiangong.boot.modules.wechat.service.MsgTemplateService;
import com.kaizhuo.tiangong.boot.modules.wechat.service.TemplateMsgLogService;
import com.kaizhuo.tiangong.boot.modules.wechat.service.TemplateMsgService;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxUserService;
import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nifury
 * @date 2017-9-27
 */
@Service
@RequiredArgsConstructor
public class TemplateMsgServiceImpl implements TemplateMsgService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TemplateMsgLogService templateMsgLogService;
    private final WxMpService wxService;
    @Autowired
    MsgTemplateService msgTemplateService;
    @Autowired
    WxUserService wxUserService;

    /**
     * 发送微信模版消息,使用固定线程的线程池
     */
    @Override
    @Async
    public void sendTemplateMsg(WxMpTemplateMessage msg) {
        TaskExcutor.submit(() -> {
            String result;
            try {
                result = wxService.getTemplateMsgService().sendTemplateMsg(msg);
            } catch (WxErrorException e) {
                result = e.getMessage();
            }

            //保存发送日志
            TemplateMsgLog log = new TemplateMsgLog(msg, result);
            templateMsgLogService.addLog(log);
        });
    }

    @Override
	@Async
    public void sendMsgBatch(TemplateMsgBatchForm form) {
		logger.info("批量发送模板消息任务开始,参数：{}",form.toString());
		WxMpTemplateMessage.WxMpTemplateMessageBuilder builder = WxMpTemplateMessage.builder()
				.templateId(form.getTemplateId())
				.url(form.getUrl())
				.miniProgram(form.getMiniprogram())
				.data(form.getData());
		Map<String, Object> filterParams = form.getWxUserFilterParams();
		if(filterParams==null)filterParams=new HashMap<>();
		long currentPage=1L,totalPages=Long.MAX_VALUE;
        //每页查询500条
		filterParams.put("limit","500");
		while (currentPage<=totalPages){
			filterParams.put("page",String.valueOf(currentPage));
            //按条件查询用户
			IPage<WxUser> wxUserIPage = wxUserService.queryPage(filterParams);
			logger.info("批量发送模板消息任务,使用查询条件，处理第{}页，总用户数：{}",currentPage,wxUserIPage.getTotal());
			wxUserIPage.getRecords().forEach(user->{
				WxMpTemplateMessage msg = builder.toUser(user.getOpenid()).build();
				this.sendTemplateMsg(msg);
			});
			currentPage=wxUserIPage.getCurrent()+1L;
			totalPages=wxUserIPage.getPages();
		}
		logger.info("批量发送模板消息任务结束");
    }

}
