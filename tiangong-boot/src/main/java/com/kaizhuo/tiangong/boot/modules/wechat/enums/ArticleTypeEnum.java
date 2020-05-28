package com.kaizhuo.tiangong.boot.modules.wechat.enums;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.enums
 * @description: 定义文章类型
 * @author: miaochen
 * @create: 2020-05-24 22:47
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public enum ArticleTypeEnum {
    COMMON(1), POPUP(2), NOTICE(3), IMAGE(4), QUESTION(5);
    private int value;

    ArticleTypeEnum(int type) {
        this.value = type;
    }

    public int getValue() {
        return this.value;
    }

    public static ArticleTypeEnum of(String name) {
        try {
            return ArticleTypeEnum.valueOf(name);
        } catch (Exception e) {
            return null;
        }
    }

}
