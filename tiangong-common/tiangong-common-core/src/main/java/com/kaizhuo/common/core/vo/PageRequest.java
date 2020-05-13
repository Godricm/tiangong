package com.kaizhuo.common.core.vo;

import com.kaizhuo.common.core.constants.Constants;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.vo
 * @description: 分页参数
 * @author: miaochen
 * @create: 2020-05-11 22:23
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class PageRequest {
    @ApiModelProperty("每页大小")
    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
    @ApiModelProperty("页码")
    private Integer pageNum = Constants.DEFAULT_PAGE_NUM;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
