package com.kaizhuo.tiangong.boot.common.util;

import java.security.MessageDigest;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.common.util
 * @description:
 * @author: miaochen
 * @create: 2020-05-26 22:00
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class SHA1Util {
    public static String sha1(String s) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得SHA1摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("sha-1");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
