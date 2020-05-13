package com.kaizhuo.tiangong.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName(value = "tb_authority")
public class Authority {
    private String username;
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
