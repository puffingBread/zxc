package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.Reward;

import java.util.Date;

public class RewardVo {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Integer amount;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

    public static RewardVo toVo(Reward reward) {
        if (reward == null) {
            return null;
        }

        RewardVo rewardVo = new RewardVo();
        rewardVo.setId(reward.getId());
        rewardVo.setDynamicId(reward.getDynamicId());
        rewardVo.setUserId(reward.getUserId());
        rewardVo.setAmount(reward.getAmount());
        rewardVo.setCreatedTime(reward.getCreatedTime());
        rewardVo.setUpdateTime(reward.getUpdateTime());
        rewardVo.setStatus(reward.getStatus());

        return rewardVo;
    }

    public static Reward toModel(RewardVo rewardVo) {
        if (rewardVo == null) {
            return null;
        }

        Reward reward = new Reward();
        reward.setId(rewardVo.getId());
        reward.setDynamicId(rewardVo.getDynamicId());
        reward.setUserId(rewardVo.getUserId());
        reward.setAmount(rewardVo.getAmount());
        reward.setCreatedTime(rewardVo.getCreatedTime());
        reward.setUpdateTime(rewardVo.getUpdateTime());
        reward.setStatus(rewardVo.getStatus());

        return reward;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
