package com.kaizhuo.tiangong.boot.modules.wx.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.wx.entity.WxQrCode;
import com.kaizhuo.tiangong.boot.modules.wx.form.WxQrCodeForm;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service
 * @description: 公众号带参二维码
 * @author: miaochen
 * @create: 2020-05-25 22:53
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface WxQrCodeService extends BaseService<WxQrCode> {
    /**
     * 创建公众号带参二维码
     *
     * @param form
     * @return
     */
    WxMpQrCodeTicket createQrCode(WxQrCodeForm form) throws WxErrorException;
}
