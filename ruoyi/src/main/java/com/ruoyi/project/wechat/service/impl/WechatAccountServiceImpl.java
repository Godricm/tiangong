package com.ruoyi.project.wechat.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.wechat.mapper.WechatAccountMapper;
import com.ruoyi.project.wechat.domain.WechatAccount;
import com.ruoyi.project.wechat.service.IWechatAccountService;

/**
 * 微信公众号Service业务层处理
 * 
 * @author godrci
 * @date 2020-06-24
 */
@Service
public class WechatAccountServiceImpl implements IWechatAccountService 
{
    @Autowired
    private WechatAccountMapper wechatAccountMapper;

    /**
     * 查询微信公众号
     * 
     * @param wechatId 微信公众号ID
     * @return 微信公众号
     */
    @Override
    public WechatAccount selectWechatAccountById(Long wechatId)
    {
        return wechatAccountMapper.selectWechatAccountById(wechatId);
    }

    /**
     * 查询微信公众号列表
     * 
     * @param wechatAccount 微信公众号
     * @return 微信公众号
     */
    @Override
    public List<WechatAccount> selectWechatAccountList(WechatAccount wechatAccount)
    {
        return wechatAccountMapper.selectWechatAccountList(wechatAccount);
    }

    /**
     * 新增微信公众号
     * 
     * @param wechatAccount 微信公众号
     * @return 结果
     */
    @Override
    public int insertWechatAccount(WechatAccount wechatAccount)
    {
        wechatAccount.setCreateTime(DateUtils.getNowDate());
        return wechatAccountMapper.insertWechatAccount(wechatAccount);
    }

    /**
     * 修改微信公众号
     * 
     * @param wechatAccount 微信公众号
     * @return 结果
     */
    @Override
    public int updateWechatAccount(WechatAccount wechatAccount)
    {
        wechatAccount.setUpdateTime(DateUtils.getNowDate());
        return wechatAccountMapper.updateWechatAccount(wechatAccount);
    }

    /**
     * 批量删除微信公众号
     * 
     * @param wechatIds 需要删除的微信公众号ID
     * @return 结果
     */
    @Override
    public int deleteWechatAccountByIds(Long[] wechatIds)
    {
        return wechatAccountMapper.deleteWechatAccountByIds(wechatIds);
    }

    /**
     * 删除微信公众号信息
     * 
     * @param wechatId 微信公众号ID
     * @return 结果
     */
    @Override
    public int deleteWechatAccountById(Long wechatId)
    {
        return wechatAccountMapper.deleteWechatAccountById(wechatId);
    }
}
