package com.kaizhuo.tiangong.boot.modules.wechat.controller;

import com.kaizhuo.tiangong.boot.common.util.Md5Util;
import com.kaizhuo.tiangong.boot.common.util.SHA1Util;
import com.kaizhuo.tiangong.boot.common.util.URIUtil;
import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.utils.CookieUtil;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wechat.form.CodeToOpenidForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.controller
 * @description: 微信网页授权相关
 * @author: miaochen
 * @create: 2020-05-26 21:46
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping("/v1/wx/wxAuth")
@RequiredArgsConstructor
@Slf4j
public class WxAuthController {

    private final WxMpService wxService;
    @Value("${wx.mp.configs[0].appid}")
    private String appId;
    @Value("${server.baseAddress}")
    private String appBaseAddress;

    @GetMapping("/getCode")
    @CrossOrigin
    public String getCode(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam(required = false) String state,
                          @RequestParam(required = false) String code,
                          @RequestParam(required = false) String redirect) throws Exception {
        log.info("获取微信授权code,redirect=" + redirect);
        log.info("获取微信授权code,state=" + state);
        if (StringUtils.isEmpty(code) && !StringUtils.isEmpty(redirect)) {
            String authUrl = wxService.oauth2buildAuthorizationUrl(appBaseAddress + request.getRequestURI(), WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(redirect, "utf-8"));
            log.info("获取微信授权code,重定向到" + authUrl);
            response.sendRedirect(authUrl);
            return null;
        } else if (!StringUtils.isEmpty(code) && Pattern.matches("[a-zA-z]+://[^\\s]*", state)) {
            String returnUrl = URIUtil.appendUri(state, "code=" + code);
            log.info("授权完成，重定向到：" + returnUrl);
            response.sendRedirect(returnUrl);
            return null;
        }
        return "parameters error";
    }

    /**
     * 使用微信授权code换取openid
     *
     * @param request
     * @param response
     * @param form
     * @return
     */
    @PostMapping("/codeToOpenid")
    @CrossOrigin
    public ResponseVo<String> codeToOpenId(HttpServletRequest request, HttpServletResponse response, @RequestBody CodeToOpenidForm form){
        String code=form.getCode();
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxService.oauth2getAccessToken(code);
            String openid = wxMpOAuth2AccessToken.getOpenId();
            CookieUtil.setCookie(response, "openid", openid, 365 * 24 * 60 * 60);
            String openidToken = Md5Util.getMD5AndSalt(openid);
            CookieUtil.setCookie(response, "openidToken", openidToken, 365 * 24 * 60 * 60);
            return new ResponseVo<>(openid);
        } catch (WxErrorException e) {
            log.error("code换取openid失败", e);
            return new ResponseVo<>(CoreErrorCode.WX_AUTH_ERROR.getCode(), e.getError().getErrorMsg());
        }
    }

    /**
     * 获取微信分享的签名配置
     * 允许跨域（只有微信公众号添加了js安全域名的网站才能加载微信分享，故这里不对域名进行校验）
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/getShareSignature")
    public ResponseVo<Map<String,String>> getShareSignature(HttpServletRequest request, HttpServletResponse response) throws WxErrorException {
        // 1.拼接url（当前网页的URL，不包含#及其后面部分）
        String wxShareUrl = request.getHeader("Referer");
        if (!StringUtils.isEmpty(wxShareUrl)) {
            wxShareUrl = wxShareUrl.split("#")[0];
        } else {
            return ResponseVo.error("地址不正确，微信分享加载失败");
        }
        Map<String, String> wxMap = new TreeMap<>();
        String wxNoncestr = UUID.randomUUID().toString();
        String wxTimestamp = (System.currentTimeMillis() / 1000) + "";
        wxMap.put("noncestr", wxNoncestr);
        wxMap.put("timestamp", wxTimestamp);
        wxMap.put("jsapi_ticket", wxService.getJsapiTicket());
        wxMap.put("url", wxShareUrl);

        // 加密获取signature
        StringBuilder wxBaseString = new StringBuilder();
        wxMap.forEach((key, value) -> wxBaseString.append(key).append("=").append(value).append("&"));
        String wxSignString = wxBaseString.substring(0, wxBaseString.length() - 1);
        // signature
        String wxSignature = SHA1Util.sha1(wxSignString);
        Map<String, String> resMap = new TreeMap<>();
        resMap.put("appId", appId);
        resMap.put("wxTimestamp", wxTimestamp);
        resMap.put("wxNoncestr", wxNoncestr);
        resMap.put("wxSignature", wxSignature);
        return new ResponseVo<>(resMap);
    }
}
