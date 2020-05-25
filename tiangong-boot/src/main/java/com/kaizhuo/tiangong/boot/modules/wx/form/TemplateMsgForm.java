package com.kaizhuo.tiangong.boot.modules.wx.form;

import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.exception.BaseException;
import lombok.Data;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.form
 * @description:
 * @author: miaochen
 * @create: 2020-05-24 22:52
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class TemplateMsgForm {
    private String openid;
    private String msg;
    private String template;


    public boolean isValid() {
        if (openid == null || openid.isEmpty() || msg == null || msg.isEmpty() || template == null || template.isEmpty()) {
            throw new BaseException(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode());
        }
        return true;
    }
}
