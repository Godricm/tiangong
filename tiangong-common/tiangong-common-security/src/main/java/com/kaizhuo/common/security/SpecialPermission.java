package com.kaizhuo.common.security;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.security
 * @description:
 * @author: miaochen
 * @create: 2020-05-14 21:50
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/

/**
 * 记录两个特殊权限，管理员、基础账号。约定前端：账号拥有以下特殊权限值时会拥有更高权限，如所有功能块可见等。
 */
public class SpecialPermission {
    public static final String ADMIN = "[ADMIN]";
    public static final String BASIC = "[BASIC]";
}
