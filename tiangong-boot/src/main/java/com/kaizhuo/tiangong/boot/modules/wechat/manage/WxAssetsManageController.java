package com.kaizhuo.tiangong.boot.modules.wechat.manage;

import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wechat.form.MaterialFileDeleteForm;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxAssetsService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.material.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 微信公众号素材管理
 * 参考官方文档：https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html
 * 参考WxJava开发文档：https://github.com/Wechat-Group/WxJava/wiki/MP_永久素材管理
 */
@RestController
@RequestMapping("/v1/manager/wxAssets")
public class WxAssetsManageController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    WxAssetsService wxAssetsService;

    /**
     * 获取素材总数
     *
     * @return
     * @throws WxErrorException
     */
    @GetMapping("/materialCount")
    public ResponseVo<WxMpMaterialCountResult> materialCount() throws WxErrorException {
        WxMpMaterialCountResult res = wxAssetsService.materialCount();
        return new ResponseVo<>(res);
    }

    /**
     * 获取素材总数
     *
     * @return
     * @throws WxErrorException
     */
    @GetMapping("/materialNewsInfo")
    public ResponseVo<WxMpMaterialNews> materialNewsInfo(String mediaId) throws WxErrorException {
        WxMpMaterialNews res = wxAssetsService.materialNewsInfo(mediaId);
        return new ResponseVo<>(res);
    }


    /**
     * 根据类别分页获取非图文素材列表
     *
     * @param type
     * @param page
     * @return
     * @throws WxErrorException
     */
    @GetMapping("/materialFileBatchGet")
    @RequiresPermissions("wx:wxassets:list")
    public ResponseVo<WxMpMaterialFileBatchGetResult> materialFileBatchGet(@RequestParam(defaultValue = "image") String type,
                                  @RequestParam(defaultValue = "1") int page) throws WxErrorException {
        WxMpMaterialFileBatchGetResult res = wxAssetsService.materialFileBatchGet(type,page);
        return new ResponseVo<>(res);
    }

    /**
     * 分页获取图文素材列表
     *
     * @param page
     * @return
     * @throws WxErrorException
     */
    @GetMapping("/materialNewsBatchGet")
    @RequiresPermissions("wx:wxassets:list")
    public ResponseVo<WxMpMaterialNewsBatchGetResult> materialNewsBatchGet(@RequestParam(defaultValue = "1") int page) throws WxErrorException {
        WxMpMaterialNewsBatchGetResult res = wxAssetsService.materialNewsBatchGet(page);
        return new ResponseVo<>(res);
    }

    /**
     * 添加图文永久素材
     *
     * @param articles
     * @return
     * @throws WxErrorException
     */
    @PostMapping("/materialNewsUpload")
    @RequiresPermissions("wx:wxassets:save")
    public ResponseVo<WxMpMaterialUploadResult> materialNewsUpload(@RequestBody List<WxMpMaterialNews.WxMpMaterialNewsArticle> articles) throws WxErrorException {
        if(articles.isEmpty()) {
            return new ResponseVo<>(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode(),"图文列表不得为空");
        }
        WxMpMaterialUploadResult res = wxAssetsService.materialNewsUpload(articles);
        return new ResponseVo(res);
    }

    /**
     * 修改图文素材文章
     *
     * @param form
     * @return
     * @throws WxErrorException
     */
    @PostMapping("/materialArticleUpdate")
    @RequiresPermissions("wx:wxassets:save")
    public ResponseVo materialArticleUpdate(@RequestBody WxMpMaterialArticleUpdate form) throws WxErrorException {
        if(form.getArticles()==null) {
            return new ResponseVo(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode(),"文章不得为空");
        }
        wxAssetsService.materialArticleUpdate(form);
        return ResponseVo.ok();
    }

    /**
     * 添加多媒体永久素材
     *
     * @param file
     * @param fileName
     * @param mediaType
     * @return
     * @throws WxErrorException
     * @throws IOException
     */
    @PostMapping("/materialFileUpload")
    @RequiresPermissions("wx:wxassets:save")
    public ResponseVo<WxMpMaterialUploadResult> materialFileUpload(MultipartFile file, String fileName, String mediaType) throws WxErrorException, IOException {
        if (file == null) {
            return new ResponseVo(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode(),"文件不得为空");
        }
        WxMpMaterialUploadResult res = wxAssetsService.materialFileUpload(mediaType,fileName,file);
        return new ResponseVo(res);
    }

    /**
     * 删除素材
     *
     * @param form
     * @return
     * @throws WxErrorException
     * @throws IOException
     */
    @PostMapping("/materialDelete")
    @RequiresPermissions("wx:wxassets:delete")
    public ResponseVo materialDelete(@RequestBody MaterialFileDeleteForm form) throws WxErrorException, IOException {
        boolean res = wxAssetsService.materialDelete(form.getMediaId());
        return new ResponseVo(res);
    }

}
