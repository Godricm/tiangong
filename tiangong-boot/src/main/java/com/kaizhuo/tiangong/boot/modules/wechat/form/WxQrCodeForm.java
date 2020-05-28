package com.kaizhuo.tiangong.boot.modules.wechat.form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.form
 * @description:
 * @author: miaochen
 * @create: 2020-05-24 22:44
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class WxQrCodeForm {
    @NotEmpty(message = "场景值ID不得为空")
    @Size(min = 1, max = 64, message = "场景值长度限制为1到64")
    private String sceneStr;
    @Max(value = 2592000, message = "过期时间不得超过30天")
    private Integer expireSeconds;
    private Boolean isTemp = true;
}
