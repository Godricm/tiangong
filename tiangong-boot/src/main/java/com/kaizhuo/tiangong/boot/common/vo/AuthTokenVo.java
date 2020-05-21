
package com.kaizhuo.tiangong.boot.common.vo;

import org.apache.shiro.authc.AuthenticationToken;

public class AuthTokenVo implements AuthenticationToken {
    private String userId;
    private String type;
    private String token;

    public AuthTokenVo() {
    }

    public AuthTokenVo(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return getUserId();
    }

    @Override
    public Object getCredentials() {
        return getToken();
    }
}
