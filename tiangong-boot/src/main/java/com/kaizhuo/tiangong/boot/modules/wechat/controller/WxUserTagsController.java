package com.kaizhuo.tiangong.boot.modules.wechat.controller;

import com.alibaba.fastjson.JSONArray;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxUser;
import com.kaizhuo.tiangong.boot.modules.wechat.form.WxUserTaggingForm;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxUserService;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxUserTagsService;
import me.chanjar.weixin.common.error.WxError;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wxUserTags")
public class WxUserTagsController {
    @Autowired
    WxUserTagsService wxUserTagsService;
    @Autowired
    WxUserService wxUserService;

    @GetMapping("/userTags")
    public ResponseVo<JSONArray> userTags(@CookieValue String openid){
        if(openid==null){
            return ResponseVo.error("none_openid");
        }
        WxUser wxUser = wxUserService.getById(openid);
        return new ResponseVo<>(wxUser.getTagidList());
    }

    @PostMapping("/tagging")
    public ResponseVo tagging(@CookieValue String openid , @RequestBody WxUserTaggingForm form) throws WxErrorException {
        try {
            wxUserTagsService.tagging(form.getTagid(),openid);
        }catch (WxErrorException e){
            WxError error = e.getError();
            //未关注公众号
            if(50005==error.getErrorCode()){
                return ResponseVo.error("not_subscribed");
            }else {
                return ResponseVo.error(error.getErrorMsg());
            }
        }
        return ResponseVo.ok();
    }

    @PostMapping("/untagging")
    public ResponseVo untagging(@CookieValue String openid , @RequestBody WxUserTaggingForm form) throws WxErrorException {
        wxUserTagsService.untagging(form.getTagid(),openid);
        return ResponseVo.ok();
    }
}
