package com.kaizhuo.tiangonguser.service.impl;

import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangonguser.constants.SystemErrorCode;
import com.kaizhuo.tiangonguser.entity.Param;
import com.kaizhuo.tiangonguser.exception.SystemException;
import com.kaizhuo.tiangonguser.mapper.ParamMapper;
import com.kaizhuo.tiangonguser.service.ParamService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:22
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
@Service
public class ParamServiceImpl extends BaseServiceImpl<ParamMapper, Param> implements ParamService {
    @Override
    public boolean removeById(Serializable id) {
        Param param = getById(id);
        if(param.getSystemFlag()){
            throw new SystemException(SystemErrorCode.SYSTEM_PARAM_CANNOT_DELETE_ERROR.getCode());
        }

        return super.removeById(id);
    }
}
