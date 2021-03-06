package com.kaizhuo.tiangong.boot.modules.admin.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class ArticleVo {
    @ApiModelProperty(value = "文章ID")
    private Long articleId;

    @ApiModelProperty(value = "文章标题")
    private String articleTitle;

    @ApiModelProperty(value = "文章分类ID")
    private Long articleCategoryId;

    @ApiModelProperty(value = "文章类型  1  文章  2  图集")
    private Integer type;

    @ApiModelProperty(value = "文章内容")
    private String articleContent;

    @ApiModelProperty(value = "发布时间")
    private Date publishTime;

    @ApiModelProperty(value = "文章作者ID")
    private Long authorId;

    @ApiModelProperty(value = "文章作者名称")
    private String authorName;

    @ApiModelProperty(value = "阅读量")
    private Long readCount;

    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date ct;

    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date ut;

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

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
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
}
