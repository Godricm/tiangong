package com.kaizhuo.common.core.exception;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.exception
 * @description:
 * @author: miaochen
 * @create: 2020-05-14 20:39
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * //异常时返回给前端的数据格式对象。
 * //暂时就一个msg进行异常消息返回，如果需要更细致的内容，手动添加属性，并在调用的地方赋值就可以了
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResultModel {
    public String msg;
}
