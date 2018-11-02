package com.puffingBread.zxc.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Administrator on 2017/8/3.
 */
@Entity
public class Comment {
    private Long dynamicId;
    private String content;
    private Long userId;
    private Timestamp createdTime;
    private Timestamp updateTime;
    private Integer status;
    private Long operatorId;

    @Basic
    @Column(name = "dynamic_id", nullable = false)
    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "created_time", nullable = false)
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "operator_id", nullable = true)
    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (!dynamicId.equals(comment.dynamicId)) return false;
        if (!content.equals(comment.content)) return false;
        if (!userId.equals(comment.userId)) return false;
        if (!createdTime.equals(comment.createdTime)) return false;
        if (!updateTime.equals(comment.updateTime)) return false;
        if (!status.equals(comment.status)) return false;
        if (!operatorId.equals(comment.operatorId)) return false;
        return id.equals(comment.id);
    }

    @Override
    public int hashCode() {
        int result = dynamicId.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + createdTime.hashCode();
        result = 31 * result + updateTime.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + operatorId.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
