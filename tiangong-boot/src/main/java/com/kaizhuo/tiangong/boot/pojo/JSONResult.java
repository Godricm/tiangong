package com.kaizhuo.tiangong.boot.pojo;

import org.json.JSONObject;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.pojo
 * @description:
 * @author: miaochen
 * @create: 2020-05-04 17:34
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class JSONResult {
    public static String fillResultString(Integer status, String message, Object result){
        JSONObject jsonObject = new JSONObject(){{
            put("status", status);
            put("message", message);
            put("result", result);
        }};

        return jsonObject.toString();
    }
}
