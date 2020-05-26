package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wx.form.WxUserBatchTaggingForm;
import com.kaizhuo.tiangong.boot.modules.wx.form.WxUserTagForm;
import com.kaizhuo.tiangong.boot.modules.wx.service.WxUserService;
import com.kaizhuo.tiangong.boot.modules.wx.service.WxUserTagsService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/wxUserTags")
public class WxUserTagsManageController {
    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private WxUserTagsService wxUserTagsService;

    /**
     * 查询用户标签
     */
    @GetMapping("/list")
    @RequiresPermissions("wx:wxuser:info")
    public ResponseVo<List<WxUserTag>> list() throws WxErrorException {
        List<WxUserTag> wxUserTags =  wxUserTagsService.getWxTags();
        return new ResponseVo(wxUserTags);
    }

    /**
     * 修改或新增标签
     */
    @PostMapping("/save")
    @RequiresPermissions("wx:wxuser:save")
    public ResponseVo save(@RequestBody WxUserTagForm form) throws WxErrorException{
        Long tagid = form.getId();
        if(tagid==null || tagid<=0){
            wxUserTagsService.creatTag(form.getName());
        }else {
            wxUserTagsService.updateTag(tagid,form.getName());
        }
        return ResponseVo.ok();
    }

    /**
     * 删除标签
     */
    @PostMapping("/delete/{tagid}")
    @RequiresPermissions("wx:wxuser:save")
    public ResponseVo delete(@PathVariable("tagid") Long tagid) throws WxErrorException{
        if(tagid==null || tagid<=0){
            return new ResponseVo(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode(),"标签ID不得为空");
        }
        wxUserTagsService.deleteTag(tagid);
        return ResponseVo.ok();
    }

    /**
     * 批量给用户打标签
     */
    @PostMapping("/batchTagging")
    @RequiresPermissions("wx:wxuser:save")
    public ResponseVo batchTagging(@RequestBody WxUserBatchTaggingForm form) throws WxErrorException{
        wxUserTagsService.batchTagging(form.getTagid(),form.getOpenidList());
        return ResponseVo.ok();
    }
    /**
     * 批量移除用户标签
     */
    @PostMapping("/batchUnTagging")
    @RequiresPermissions("wx:wxuser:save")
    public ResponseVo batchUnTagging(@RequestBody WxUserBatchTaggingForm form) throws WxErrorException{
        wxUserTagsService.batchUnTagging(form.getTagid(),form.getOpenidList());
        return ResponseVo.ok();
    }
}
