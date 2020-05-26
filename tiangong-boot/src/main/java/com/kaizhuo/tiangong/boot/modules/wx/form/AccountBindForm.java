package com.kaizhuo.tiangong.boot.modules.wx.form;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.form
 * @description: 账号绑定
 * @author: miaochen
 * @create: 2020-05-24 22:48
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class AccountBindForm {
    String phoneNum;
    String idCodeSuffix;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
