package com.kaizhuo.tiangong.boot.core.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.core.util
 * @description:
 * @author: miaochen
 * @create: 2020-05-18 22:24
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class Md5Util {
    public static String createSaltMd5(String password) {
        String md5First = DigestUtils.md5Hex(password);
        // 取其中某段字符串作为盐值
        String salt = md5First.substring(1, 11);
        // 开始加盐加密
        return DigestUtils.md5Hex(salt + md5First);
    }
}
