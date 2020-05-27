package com.kaizhuo.tiangong.boot.modules.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kaizhuo.tiangong.boot.framework.controller.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


@TableName("core_article")
@ApiModel(value="Article对象", description="文章信息")
public class Article extends BaseModel<Article> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;

    @ApiModelProperty(value = "文章标题")
    private String articleTitle;

    @ApiModelProperty(value = "文章分类ID")
    private Long articleCategoryId;

    @ApiModelProperty(value = "文章类型  1  文章  2  图集")
    private Integer type;

    @ApiModelProperty(value = "发布时间")
    private Date publishTime;

    @ApiModelProperty(value = "文章作者ID")
    private Long authorId;

    @ApiModelProperty(value = "文章作者名称")
    private String authorName;

    @ApiModelProperty(value = "阅读量")
    private Long readCount;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date ct;

    @ApiModelProperty(value = "更新时间", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ut;

    @ApiModelProperty(value = "删除标识位 0 未删除  1 已删除", hidden = true)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "乐观锁标识", hidden = true)
    @Version
    private Long version;


    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Long getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(Long articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }

    public Date getUt() {
        return ut;
    }

    public void setUt(Date ut) {
        this.ut = ut;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.articleId;
    }

    @Override
    public String toString() {
        return "Article{" +
        "articleId=" + articleId +
        ", articleTitle=" + articleTitle +
        ", articleCategoryId=" + articleCategoryId +
        ", type=" + type +
        ", publishTime=" + publishTime +
        ", authorId=" + authorId +
        ", authorName=" + authorName +
        ", readCount=" + readCount +
        ", ct=" + ct +
        ", ut=" + ut +
        ", isDel=" + isDel +
        ", version=" + version +
        "}";
    }
}
