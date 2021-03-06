package com.humor.zxc.vo;

import com.humor.zxc.model.Content;
import com.humor.zxc.model.Dynamic;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/4.
 */
public class DynamicVo implements Serializable {
    private Long id;
    private Long userId;
    private String nikeName;
    private ContentVo content;
    private Long createdTime;
    private Long updateTime;

    private Integer browserCount;
    private Integer commentCount;
    private Integer retweetCount;
    private Integer thumbUpCount;
    private Integer rewardCount;


    public static DynamicVo toVo(Dynamic dynamic) {

        DynamicVo vo = new DynamicVo();
        vo.setId(dynamic.getId());
        vo.setUserId(dynamic.getUserId());
        vo.setNikeName(dynamic.getNikeName());
        vo.setCreatedTime(dynamic.getCreatedTime().getTime());
        vo.setUpdateTime(dynamic.getUpdateTime().getTime());

        return vo;
    }

    public static DynamicVo toVo(Dynamic dynamic, Content content){
        DynamicVo vo = new DynamicVo();
        vo.setId(dynamic.getId());
        vo.setUserId(dynamic.getUserId());
        vo.setNikeName(dynamic.getNikeName());
        vo.setCreatedTime(dynamic.getCreatedTime().getTime());
        vo.setUpdateTime(dynamic.getUpdateTime().getTime());

        ContentVo contentVo = new ContentVo();
        contentVo.setId(content.getId());
        contentVo.setTitle(content.getTitle());
        contentVo.setContentType(content.getContentType());
        contentVo.setContent(content.getContent());
        vo.setContent(contentVo);

        return vo;
    }

    public static Dynamic toModel(DynamicVo vo){
        Dynamic dynamic = new Dynamic();
        dynamic.setId(vo.getId());
        dynamic.setUserId(vo.getUserId());
        dynamic.setNikeName(vo.getNikeName());
        dynamic.setContentId(vo.getContent() == null ? null : vo.getContent().getId());
        if (vo.getId() == null) {
            dynamic.setCreatedTime(new Date());
        }
        dynamic.setUpdateTime(new Date());
        dynamic.setStatus(0);
        return dynamic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public ContentVo getContent() {
        return content;
    }

    public void setContent(ContentVo content) {
        this.content = content;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBrowserCount() {
        return browserCount;
    }

    public void setBrowserCount(Integer browserCount) {
        this.browserCount = browserCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Integer getThumbUpCount() {
        return thumbUpCount;
    }

    public void setThumbUpCount(Integer thumbUpCount) {
        this.thumbUpCount = thumbUpCount;
    }

    public Integer getRewardCount() {
        return rewardCount;
    }

    public void setRewardCount(Integer rewardCount) {
        this.rewardCount = rewardCount;
    }
}
