package com.kaizhuo.tiangong.boot.modules.wechat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxUser;
import me.chanjar.weixin.common.error.WxErrorException;

import java.util.List;
import java.util.Map;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service
 * @description: 微信用户服务
 * @author: miaochen
 * @create: 2020-05-25 23:01
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface WxUserService extends BaseService<WxUser> {
    /**
     * 分页查询用户数据
     * @param params
     * @return
     */
    IPage<WxUser> queryPage(Map<String, Object> params);

    /**
     * 根据openid更新用户信息
     *
     * @param openid
     * @return
     */
    WxUser refreshUserInfo(String openid);

    /**
     * 异步批量更新用户信息
     * @param openidList
     */
    void refreshUserInfoAsync(String[] openidList);

    /**
     * 数据存在时更新，否则新增
     *
     * @param user
     */
    void updateOrInsert(WxUser user);

    /**
     * 取消关注，更新关注状态
     *
     * @param openid
     */
    void unsubscribe(String openid);
    /**
     * 同步用户列表
     */
    void syncWxUsers();

    /**
     * 通过传入的openid列表，同步用户列表
     * @param openids
     */
    void syncWxUsers(List<String> openids) throws WxErrorException;
}
