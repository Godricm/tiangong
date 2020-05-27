package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.constants.SystemErrorCode;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Param;
import com.kaizhuo.tiangong.boot.modules.admin.exception.SystemException;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.ParamMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IParamService;
import org.springframework.stereotype.Service;

import java.io.Serializable;


@Service
public class ParamServiceImpl extends BaseServiceImpl<ParamMapper, Param> implements IParamService {
    @Override
    public boolean removeById(Serializable id) {
        Param param = getById(id);
        if(param.getSystemFlag()){
            throw new SystemException(SystemErrorCode.SYSTEM_PARAM_CANNOT_DELETE_ERROR.getCode());
        }

        return super.removeById(id);
    }
}
