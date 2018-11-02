package com.puffingBread.zxc.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/8/3.
 */
@Entity
@Table(name = "thumb_up", schema = "zxc_dynamic", catalog = "")
public class ThumbUp {
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

    @Basic
    @Column(name = "dynamic_id", nullable = false)
    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
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
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThumbUp thumbUp = (ThumbUp) o;

        if (dynamicId != thumbUp.dynamicId) return false;
        if (userId != thumbUp.userId) return false;
        if (status != thumbUp.status) return false;
        if (createdTime != null ? !createdTime.equals(thumbUp.createdTime) : thumbUp.createdTime != null) return false;
        if (updateTime != null ? !updateTime.equals(thumbUp.updateTime) : thumbUp.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dynamicId ^ (dynamicId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + status;
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
