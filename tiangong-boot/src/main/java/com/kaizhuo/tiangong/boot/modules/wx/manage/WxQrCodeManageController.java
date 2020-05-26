package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wx.entity.WxQrCode;
import com.kaizhuo.tiangong.boot.modules.wx.form.WxQrCodeForm;
import com.kaizhuo.tiangong.boot.modules.wx.service.WxQrCodeService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 公众号带参二维码管理
 * https://github.com/Wechat-Group/WxJava/wiki/MP_二维码管理
 */
@RestController
@RequestMapping("/manage/wxQrCode")
public class WxQrCodeManageController extends BaseController<WxQrCodeService, WxQrCode> {


    @Autowired
    private WxQrCodeService wxQrCodeService;

    /**
     * 创建带参二维码ticket
     */
    @PostMapping("/createTicket")
    @RequiresPermissions("wx:wxqrcode:save")
    public ResponseVo<WxMpQrCodeTicket> createTicket(@RequestBody WxQrCodeForm form) throws WxErrorException {
        WxMpQrCodeTicket ticket = wxQrCodeService.createQrCode(form);
        return new ResponseVo(ticket);
    }

}
