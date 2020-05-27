package com.kaizhuo.tiangong.boot.modules.wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.modules.wx.entity.WxQrCode;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * 公众号带参二维码
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2020-01-02 11:11:55
 */
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface WxQrCodeMapper extends BaseMapper<WxQrCode> {

}
