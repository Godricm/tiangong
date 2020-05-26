package com.kaizhuo.tiangong.boot.modules.wx.form;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.form
 * @description:
 * @author: miaochen
 * @create: 2020-05-24 22:50
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class CodeToOpenidForm {
    @NotEmpty(message = "code不得为空")
    private String code;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
