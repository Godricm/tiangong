package com.kaizhuo.tiangonguser.vo.response;

import com.kaizhuo.tiangonguser.entity.Resource;
import com.kaizhuo.tiangonguser.entity.Role;
import lombok.Data;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.response
 * @description: 授权信息
 * @author: miaochen
 * @create: 2020-05-15 21:44
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class UserAuthCache {

    private List<Role> userRoles;
    private List<Resource> userResources;
}
