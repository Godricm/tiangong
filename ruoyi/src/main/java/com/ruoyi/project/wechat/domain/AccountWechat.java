package com.ruoyi.project.wechat.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 微信公众号对象 account_wechat
 * 
 * @author ruoyi
 * @date 2020-06-21
 */
public class AccountWechat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long wechatId;

    /** 公众号名称 */
    @Excel(name = "公众号名称")
    private String name;

    /** 公众号账号 */
    @Excel(name = "公众号账号")
    private String account;

    /** 原始ID */
    @Excel(name = "原始ID")
    private String original;

    /** appid */
    @Excel(name = "appid")
    private String appKey;

    /** appsecret */
    @Excel(name = "appsecret")
    private String appSecret;

    /** 接入的token值 */
    @Excel(name = "接入的token值")
    private String token;

    /** 接入的EncodingAESKey值 */
    @Excel(name = "接入的EncodingAESKey值")
    private String encodingaeskey;

    /** 1、普通订阅号2、认证订阅号3、普通服务号4、认证服务号/认证媒体/政府订阅号 */
    @Excel(name = "1、普通订阅号2、认证订阅号3、普通服务号4、认证服务号/认证媒体/政府订阅号")
    private Integer level;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 开放平台返回的auth_refresh_token */
    @Excel(name = "开放平台返回的auth_refresh_token")
    private String authRefreshToken;

    /** 状态（0正常，1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常，1停用")
    private String status;

    /** 删除标志（0代表存在，1代表删除） */
    private String delFlag;

    public void setWechatId(Long wechatId) 
    {
        this.wechatId = wechatId;
    }

    public Long getWechatId() 
    {
        return wechatId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setOriginal(String original) 
    {
        this.original = original;
    }

    public String getOriginal() 
    {
        return original;
    }
    public void setAppKey(String appKey) 
    {
        this.appKey = appKey;
    }

    public String getAppKey() 
    {
        return appKey;
    }
    public void setAppSecret(String appSecret) 
    {
        this.appSecret = appSecret;
    }

    public String getAppSecret() 
    {
        return appSecret;
    }
    public void setToken(String token) 
    {
        this.token = token;
    }

    public String getToken() 
    {
        return token;
    }
    public void setEncodingaeskey(String encodingaeskey) 
    {
        this.encodingaeskey = encodingaeskey;
    }

    public String getEncodingaeskey() 
    {
        return encodingaeskey;
    }
    public void setLevel(Integer level) 
    {
        this.level = level;
    }

    public Integer getLevel() 
    {
        return level;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setAuthRefreshToken(String authRefreshToken) 
    {
        this.authRefreshToken = authRefreshToken;
    }

    public String getAuthRefreshToken() 
    {
        return authRefreshToken;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wechatId", getWechatId())
            .append("name", getName())
            .append("account", getAccount())
            .append("original", getOriginal())
            .append("appKey", getAppKey())
            .append("appSecret", getAppSecret())
            .append("token", getToken())
            .append("encodingaeskey", getEncodingaeskey())
            .append("level", getLevel())
            .append("country", getCountry())
            .append("province", getProvince())
            .append("city", getCity())
            .append("authRefreshToken", getAuthRefreshToken())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
