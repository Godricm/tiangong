package com.kaizhuo.tiangong.boot.modules.admin.vo.response;


import com.kaizhuo.tiangong.boot.modules.admin.entity.Resource;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Role;

import java.util.List;

public class UserAuthCache {
    private List<Role> userRoles;
    private List<Resource> userResources;

    public List<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Role> userRoles) {
        this.userRoles = userRoles;
    }

    public List<Resource> getUserResources() {
        return userResources;
    }

    public void setUserResources(List<Resource> userResources) {
        this.userResources = userResources;
    }
}
