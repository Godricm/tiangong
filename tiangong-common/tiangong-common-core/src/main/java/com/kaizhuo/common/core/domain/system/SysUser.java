package com.kaizhuo.common.core.domain.system;

import lombok.Data;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.domain.system
 * @description: 用户信息表
 * @author: miaochen
 * @create: 2020-05-04 11:26
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class SysUser {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;
}
