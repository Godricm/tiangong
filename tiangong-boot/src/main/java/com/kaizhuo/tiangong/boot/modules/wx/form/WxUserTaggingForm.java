package com.kaizhuo.tiangong.boot.modules.wx.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.form
 * @description:
 * @author: miaochen
 * @create: 2020-05-24 23:13
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class WxUserTaggingForm {
    @NotNull(message = "标签ID不得为空")
    private Long tagid;
}
