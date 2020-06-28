package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.Comment;

import java.util.Date;

public class CommentVo {

    private Long id;
    private Long dynamicId;
    private String content;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Long operatorId;

    public static CommentVo toVo(Comment comment) {
        if (comment == null) {
            return null;
        }

        CommentVo commentVo = new CommentVo();
        commentVo.setId(comment.getId());
        commentVo.setDynamicId(comment.getDynamicId());
        commentVo.setContent(comment.getContent());
        commentVo.setUserId(comment.getUserId());
        commentVo.setCreatedTime(comment.getCreatedTime());
        commentVo.setUpdateTime(comment.getUpdateTime());
        commentVo.setOperatorId(comment.getOperatorId());

        return commentVo;
    }

    public static Comment toModel(CommentVo commentVo) {
        if (commentVo == null) {
            return null;
        }

        Comment comment = new Comment();
        comment.setId(commentVo.getId());
        comment.setDynamicId(commentVo.getDynamicId());
        comment.setContent(commentVo.getContent());
        comment.setOperatorId(commentVo.getOperatorId());
        comment.setUserId(commentVo.getUserId());
        comment.setCreatedTime(commentVo.getCreatedTime());
        comment.setUpdateTime(commentVo.getUpdateTime());
        comment.setStatus(0);

        return comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}
