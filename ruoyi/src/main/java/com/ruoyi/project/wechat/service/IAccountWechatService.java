package com.ruoyi.project.wechat.service;

import java.util.List;
import com.ruoyi.project.wechat.domain.AccountWechat;

/**
 * 微信公众号Service接口
 * 
 * @author ruoyi
 * @date 2020-06-21
 */
public interface IAccountWechatService 
{
    /**
     * 查询微信公众号
     * 
     * @param wechatId 微信公众号ID
     * @return 微信公众号
     */
    public AccountWechat selectAccountWechatById(Long wechatId);

    /**
     * 查询微信公众号列表
     * 
     * @param accountWechat 微信公众号
     * @return 微信公众号集合
     */
    public List<AccountWechat> selectAccountWechatList(AccountWechat accountWechat);

    /**
     * 新增微信公众号
     * 
     * @param accountWechat 微信公众号
     * @return 结果
     */
    public int insertAccountWechat(AccountWechat accountWechat);

    /**
     * 修改微信公众号
     * 
     * @param accountWechat 微信公众号
     * @return 结果
     */
    public int updateAccountWechat(AccountWechat accountWechat);

    /**
     * 批量删除微信公众号
     * 
     * @param wechatIds 需要删除的微信公众号ID
     * @return 结果
     */
    public int deleteAccountWechatByIds(Long[] wechatIds);

    /**
     * 删除微信公众号信息
     * 
     * @param wechatId 微信公众号ID
     * @return 结果
     */
    public int deleteAccountWechatById(Long wechatId);
}
