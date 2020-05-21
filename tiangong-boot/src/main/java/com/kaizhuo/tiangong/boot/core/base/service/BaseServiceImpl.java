package com.kaizhuo.tiangong.boot.core.base.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaizhuo.tiangong.boot.core.vo.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.core.base.service
 * @description:
 * @author: miaochen
 * @create: 2020-05-11 22:22
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 转换分页参数
     * @param pageRequest
     * @return
     */
    public Page convertPageParam(PageRequest pageRequest){
        long pageNum = pageRequest.getPageNum();
        long pageSize = pageRequest.getPageSize();
        return convertPageParam(pageNum, pageSize);
    }

    /**
     * 转换分页参数
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page convertPageParam(long pageNum, long pageSize){
        return new Page(pageNum, pageSize);
    }
}
