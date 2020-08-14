package com.humor.zxc.vo;

import com.humor.zxc.model.ThumbUp;

import java.sql.Date;

public class ThumbUpVo {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;

    public static ThumbUpVo toVo(ThumbUp thumbUp) {
        if (thumbUp == null) {
            return null;
        }

        ThumbUpVo thumbUpVo = new ThumbUpVo();
        thumbUpVo.setId(thumbUp.getId());
        thumbUpVo.setDynamicId(thumbUp.getDynamicId());
        thumbUpVo.setUserId(thumbUp.getUserId());
        thumbUpVo.setCreatedTime(thumbUp.getCreatedTime());
        thumbUpVo.setUpdateTime(thumbUp.getUpdateTime());
        return thumbUpVo;
    }

    public static ThumbUp toModel(ThumbUpVo thumbUpVo) {
        if (thumbUpVo == null) {
            return null;
        }

        ThumbUp thumbUp = new ThumbUp();
        thumbUp.setId(thumbUpVo.getId());
        thumbUp.setDynamicId(thumbUpVo.getDynamicId());
        thumbUp.setUserId(thumbUpVo.getUserId());
        thumbUp.setCreatedTime(thumbUpVo.getCreatedTime());
        thumbUp.setUpdateTime(thumbUpVo.getUpdateTime());
        thumbUp.setStatus(0);

        return thumbUp;
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
}
