package com.kaizhuo.tiangong.boot.modules.generator.service.impl;

import com.kaizhuo.tiangong.boot.modules.generator.entity.TableInfo;
import com.kaizhuo.tiangong.boot.modules.generator.mapper.TableMapper;
import com.kaizhuo.tiangong.boot.modules.generator.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService implements ITableService {
    @Autowired
    private TableMapper tableMapper;

    @Override
    public List<TableInfo> selectTableList(TableInfo tableInfo) {
        return tableMapper.selectTableList(tableInfo);
    }
}
