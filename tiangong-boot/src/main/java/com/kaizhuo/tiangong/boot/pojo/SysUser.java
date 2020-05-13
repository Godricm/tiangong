package com.kaizhuo.tiangong.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.entity
 * @description: 系统用户
 * @author: miaochen
 * @create: 2020-05-04 17:25
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName(value = "tb_user")
public class SysUser {
    @TableId
    private int id;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
