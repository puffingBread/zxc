package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.Retweet;

import java.util.Date;

public class RetweetVo {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

    public static RetweetVo toVo(Retweet retweet) {
        if (retweet == null) {
            return null;
        }

        RetweetVo retweetVo = new RetweetVo();
        retweetVo.setId(retweet.getId());
        retweetVo.setDynamicId(retweet.getDynamicId());
        retweetVo.setUserId(retweet.getUserId());
        retweetVo.setCreatedTime(retweet.getCreatedTime());
        retweetVo.setUpdateTime(retweet.getUpdateTime());
        retweetVo.setStatus(retweet.getStatus());

        return retweetVo;
    }

    public static Retweet toModel(RetweetVo retweetVo) {
        if (retweetVo == null) {
            return null;
        }

        Retweet retweet = new Retweet();
        retweet.setId(retweetVo.getId());
        retweet.setDynamicId(retweetVo.getDynamicId());
        retweet.setUserId(retweetVo.getUserId());
        retweet.setCreatedTime(retweetVo.getCreatedTime());
        retweet.setUpdateTime(retweetVo.getUpdateTime());
        retweet.setStatus(retweetVo.getStatus());

        return retweet;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
