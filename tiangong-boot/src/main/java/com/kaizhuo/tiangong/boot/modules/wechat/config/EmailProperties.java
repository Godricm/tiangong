package com.kaizhuo.tiangong.boot.modules.wechat.config;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "email")
@Data
public class EmailProperties {
    private String host;
    private String username;
    private String password;
    private String port;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
