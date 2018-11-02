package com.puffingBread.zxc.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/3.
 */
@Entity
public class Dynamic {

    private Long id;
    private Long userId;
    private String nikeName;
    private Long contentId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Column(name = "nike_name", nullable = false, length = 30)
    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    @Basic
    @Column(name = "content_id", nullable = false)
    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
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

        Dynamic dynamic = (Dynamic) o;

        if (id != dynamic.id) return false;
        if (userId != dynamic.userId) return false;
        if (contentId != dynamic.contentId) return false;
        if (status != dynamic.status) return false;
        if (nikeName != null ? !nikeName.equals(dynamic.nikeName) : dynamic.nikeName != null) return false;
        if (createdTime != null ? !createdTime.equals(dynamic.createdTime) : dynamic.createdTime != null) return false;
        if (updateTime != null ? !updateTime.equals(dynamic.updateTime) : dynamic.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (nikeName != null ? nikeName.hashCode() : 0);
        result = 31 * result + (int) (contentId ^ (contentId >>> 32));
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
