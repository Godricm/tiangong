package com.ruoyi.project.wechat.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.wechat.mapper.AccountWechatMapper;
import com.ruoyi.project.wechat.domain.AccountWechat;
import com.ruoyi.project.wechat.service.IAccountWechatService;

/**
 * 微信公众号Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-06-21
 */
@Service
public class AccountWechatServiceImpl implements IAccountWechatService 
{
    @Autowired
    private AccountWechatMapper accountWechatMapper;

    /**
     * 查询微信公众号
     * 
     * @param wechatId 微信公众号ID
     * @return 微信公众号
     */
    @Override
    public AccountWechat selectAccountWechatById(Long wechatId)
    {
        return accountWechatMapper.selectAccountWechatById(wechatId);
    }

    /**
     * 查询微信公众号列表
     * 
     * @param accountWechat 微信公众号
     * @return 微信公众号
     */
    @Override
    public List<AccountWechat> selectAccountWechatList(AccountWechat accountWechat)
    {
        return accountWechatMapper.selectAccountWechatList(accountWechat);
    }

    /**
     * 新增微信公众号
     * 
     * @param accountWechat 微信公众号
     * @return 结果
     */
    @Override
    public int insertAccountWechat(AccountWechat accountWechat)
    {
        accountWechat.setCreateTime(DateUtils.getNowDate());
        return accountWechatMapper.insertAccountWechat(accountWechat);
    }

    /**
     * 修改微信公众号
     * 
     * @param accountWechat 微信公众号
     * @return 结果
     */
    @Override
    public int updateAccountWechat(AccountWechat accountWechat)
    {
        accountWechat.setUpdateTime(DateUtils.getNowDate());
        return accountWechatMapper.updateAccountWechat(accountWechat);
    }

    /**
     * 批量删除微信公众号
     * 
     * @param wechatIds 需要删除的微信公众号ID
     * @return 结果
     */
    @Override
    public int deleteAccountWechatByIds(Long[] wechatIds)
    {
        return accountWechatMapper.deleteAccountWechatByIds(wechatIds);
    }

    /**
     * 删除微信公众号信息
     * 
     * @param wechatId 微信公众号ID
     * @return 结果
     */
    @Override
    public int deleteAccountWechatById(Long wechatId)
    {
        return accountWechatMapper.deleteAccountWechatById(wechatId);
    }
}
