package com.kaizhuo.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.enums
 * @description: 登录类型
 * @author: miaochen
 * @create: 2020-05-03 18:28
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Getter
@AllArgsConstructor
public enum LoginTypeEum {
    /**
     * 账号密码登录
     */
    PWD("PWD","账号密码登录"),
    /**
     * QQ登录
     */
    QQ("QQ", "QQ登录"),

    /**
     * 微信登录
     */
    WECHAT("WX", "微信登录");

    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String description;
}
