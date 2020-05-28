package com.kaizhuo.tiangong.boot.modules.wechat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaizhuo.tiangong.boot.modules.wechat.mapper.WxQrCodeMapper;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxQrCode;
import com.kaizhuo.tiangong.boot.modules.wechat.form.WxQrCodeForm;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxQrCodeService;
import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class WxQrCodeServiceImpl extends ServiceImpl<WxQrCodeMapper, WxQrCode> implements WxQrCodeService {
    private final WxMpService wxService;


    /**
     * 创建公众号带参二维码
     *
     * @param form
     * @return
     */
    @Override
    public WxMpQrCodeTicket createQrCode(WxQrCodeForm form) throws WxErrorException {
        WxMpQrCodeTicket ticket;
        //创建临时二维码
        if (form.getIsTemp()) {
            ticket = wxService.getQrcodeService().qrCodeCreateTmpTicket(form.getSceneStr(), form.getExpireSeconds());
        } else {//创建永久二维码
            ticket = wxService.getQrcodeService().qrCodeCreateLastTicket(form.getSceneStr());
        }
        WxQrCode wxQrCode = new WxQrCode(form);
        wxQrCode.setTicket(ticket.getTicket());
        wxQrCode.setUrl(ticket.getUrl());
        if (form.getIsTemp()) {
            wxQrCode.setExpireTime(new Date(System.currentTimeMillis() + ticket.getExpireSeconds() * 1000L));
        }
        this.save(wxQrCode);
        return ticket;
    }

}
