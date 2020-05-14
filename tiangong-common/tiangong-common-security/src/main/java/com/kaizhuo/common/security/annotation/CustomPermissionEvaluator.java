package com.kaizhuo.common.security.annotation;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.security.annotation
 * @description:自定义hasPermission表达式，此方法自己实现否则hasPermission表达式不可用，spring security默认不提供
 * 方法首个参数自动传入，注解中的参数由第二个开始对应
 * 使用方法为@PreAuthorize("hasPermission(#xxxXxx,'permissionValue')")，xxxXxx可为被注解的方法的参数,permissionValue为权限值字符串
 * @author: miaochen
 * @create: 2020-05-14 20:34
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals(o1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 这个实现没使用，上一个就够用了，这个直接返回false。
     * @param authentication
     * @param serializable
     * @param s
     * @param o
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
