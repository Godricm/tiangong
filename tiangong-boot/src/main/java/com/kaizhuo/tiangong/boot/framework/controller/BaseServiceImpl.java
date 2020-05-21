
package com.kaizhuo.tiangong.boot.framework.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaizhuo.tiangong.boot.framework.vo.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
