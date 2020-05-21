package com.kaizhuo.tiangong.boot.module.user.service.impl;

import com.kaizhuo.tiangong.boot.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.module.user.constants.SystemErrorCode;
import com.kaizhuo.tiangong.boot.module.user.entity.Param;
import com.kaizhuo.tiangong.boot.module.user.exception.SystemException;
import com.kaizhuo.tiangong.boot.module.user.mapper.ParamMapper;
import com.kaizhuo.tiangong.boot.module.user.service.ParamService;
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
