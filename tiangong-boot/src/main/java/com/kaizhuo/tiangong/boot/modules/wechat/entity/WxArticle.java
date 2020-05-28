package com.kaizhuo.tiangong.boot.modules.wechat.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kaizhuo.tiangong.boot.framework.controller.BaseModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 文章抽象：帮助中心文章、公告、资讯文章等分别存储到不同的表
 * @author miaochen
 */
@Data
@TableName("wx_article")
public class WxArticle extends BaseModel<WxArticle> {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private int id;
    private int type;
    /**
     * title重复则不插入
     */
    @TableField( insertStrategy = FieldStrategy.IGNORED)
    @NotEmpty(message = "标题不得为空")
    private String title;
    private String tags;
    private String summary;
    private String content;
    private String category;
    private String subCategory;
    private Date createTime;
    private Date updateTime;
    private int openCount;
    private String targetLink;
    private String image;
}
