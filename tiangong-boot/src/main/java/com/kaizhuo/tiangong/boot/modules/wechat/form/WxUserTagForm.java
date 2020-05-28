package com.kaizhuo.tiangong.boot.modules.wechat.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.form
 * @description: 标签
 * @author: miaochen
 * @create: 2020-05-24 23:13
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class WxUserTagForm {
    private Long id;
    @NotEmpty(message = "标签名称不得为空")
    @Size(min = 1,max = 30,message = "标签名称长度必须为1-30字符")
    private String name;
}
