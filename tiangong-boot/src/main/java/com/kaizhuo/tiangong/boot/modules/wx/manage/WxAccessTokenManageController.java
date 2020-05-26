package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号菜单管理
 * 官方文档：https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html
 * WxJava开发文档：https://github.com/Wechat-Group/WxJava/wiki/MP_自定义菜单管理
 * @author miaochen
 */
@RestController
@RequestMapping("/manage/wxAccessToken")
@RequiredArgsConstructor
public class WxAccessTokenManageController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final WxMpService wxService;

    /**
     * 获取公众号菜单
     */
    @GetMapping("/getAccessToken")
    public ResponseVo getAccessToken() throws WxErrorException {
        String accessToken = wxService.getAccessToken();
        return new ResponseVo(accessToken);
    }
}
