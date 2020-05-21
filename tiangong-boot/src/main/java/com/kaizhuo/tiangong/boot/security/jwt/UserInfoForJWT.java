package com.kaizhuo.tiangong.boot.security.jwt;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.security.jwt
 * @description:
 * @author: miaochen
 * @create: 2020-05-14 21:22
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserInfoForJWT {

    /**
     *  本项目构建token时需使用用户的密码（加密后的）。验证时也会需要用户的密码（加密后的），所以当用户修改密码后，现有token会立即失效，需要重新登录。
     *  因每个系统获取用户密码的方式不同，此方法作为一个接口可供自行实现。若找不到任何实现类，运行会报错
     * @param userId
     * @return
     */
    String getSecret(Object userId);
}
