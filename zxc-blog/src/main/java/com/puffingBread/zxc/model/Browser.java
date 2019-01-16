package com.puffingBread.zxc.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/3.
 */
@Entity
public class Browser {
    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

    @Id
    @TableGenerator(name = "PKGenerator",
            table = "id_holder",
            pkColumnName = "id_name",
            valueColumnName = "id_counter",
            pkColumnValue = "BrowserId",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PKGenerator")
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

        Browser browser = (Browser) o;

        if (dynamicId != browser.dynamicId) return false;
        if (userId != browser.userId) return false;
        if (status != browser.status) return false;
        if (createdTime != null ? !createdTime.equals(browser.createdTime) : browser.createdTime != null) return false;
        if (updateTime != null ? !updateTime.equals(browser.updateTime) : browser.updateTime != null) return false;

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

}
