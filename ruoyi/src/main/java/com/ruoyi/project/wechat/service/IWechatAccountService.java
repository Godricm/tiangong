package com.ruoyi.project.wechat.service;

import java.util.List;
import com.ruoyi.project.wechat.domain.WechatAccount;

/**
 * 微信公众号Service接口
 * 
 * @author godrci
 * @date 2020-06-24
 */
public interface IWechatAccountService 
{
    /**
     * 查询微信公众号
     * 
     * @param wechatId 微信公众号ID
     * @return 微信公众号
     */
    public WechatAccount selectWechatAccountById(Long wechatId);

    /**
     * 查询微信公众号列表
     * 
     * @param wechatAccount 微信公众号
     * @return 微信公众号集合
     */
    public List<WechatAccount> selectWechatAccountList(WechatAccount wechatAccount);

    /**
     * 新增微信公众号
     * 
     * @param wechatAccount 微信公众号
     * @return 结果
     */
    public int insertWechatAccount(WechatAccount wechatAccount);

    /**
     * 修改微信公众号
     * 
     * @param wechatAccount 微信公众号
     * @return 结果
     */
    public int updateWechatAccount(WechatAccount wechatAccount);

    /**
     * 批量删除微信公众号
     * 
     * @param wechatIds 需要删除的微信公众号ID
     * @return 结果
     */
    public int deleteWechatAccountByIds(Long[] wechatIds);

    /**
     * 删除微信公众号信息
     * 
     * @param wechatId 微信公众号ID
     * @return 结果
     */
    public int deleteWechatAccountById(Long wechatId);
}
