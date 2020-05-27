package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.constants.CoreConstants;
import com.kaizhuo.tiangong.boot.modules.admin.entity.DictData;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.DictDataMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IDictDataService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DictDataServiceImpl extends BaseServiceImpl<DictDataMapper, DictData> implements IDictDataService {
    @Override
    public boolean save(DictData entity) {
        // 判断该数据同类型是否已有默认值,有则更新为非默认值
        Integer isDefault = entity.getIsDefault();
        if(CoreConstants.IS_DEFAULT_Y.equals(isDefault)){
            String dictType = entity.getDictType();
            updateDictDataDefault(dictType);
        }

        return super.save(entity);
    }

    @Override
    public boolean updateById(DictData entity) {
        // 判断该数据同类型是否已有默认值,有则更新为非默认值
        Integer isDefault = entity.getIsDefault();
        if(CoreConstants.IS_DEFAULT_Y.equals(isDefault)){
            String dictType = entity.getDictType();
            updateDictDataDefault(dictType);
        }

        return super.updateById(entity);
    }

    /**
     * 根据dictType找出dictData的默认值,并更新为非默认值
     * @param dictType
     */
    private void updateDictDataDefault(String dictType){
        List<DictData> dictDataByType = getDictDataByType(dictType);
        if(!CollectionUtils.isEmpty(dictDataByType)){
            for(DictData dictData : dictDataByType){
                if(CoreConstants.IS_DEFAULT_Y.equals(dictData.getIsDefault())){
                    dictData.setIsDefault(CoreConstants.IS_DEFAULT_N);
                    updateById(dictData);
                    break;
                }
            }
        }
    }

    /**
     * 根据dictType查找dictData数据列表
     * @param dictType
     * @return
     */
    private List<DictData> getDictDataByType(String dictType){
        List<DictData> dictDataByType = list(new QueryWrapper<DictData>().eq("dict_type", dictType));

        return dictDataByType;
    }
}
