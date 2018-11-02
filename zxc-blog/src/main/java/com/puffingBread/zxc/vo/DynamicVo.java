package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.Content;
import com.puffingBread.zxc.model.Dynamic;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/4.
 */
public class DynamicVo implements Serializable {
    private long id;
    private long userId;
    private String nikeName;
    private ContentVo content;
    private Long createdTime;
    private Long updateTime;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DynamicVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", nikeName='" + nikeName + '\'' +
                ", content=" + content +
                ", createdTime=" + createdTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }

    public static DynamicVo toVo(Dynamic dynamic) {

        DynamicVo vo = new DynamicVo();
        vo.setId(dynamic.getId());
        vo.setUserId(dynamic.getUserId());
        vo.setNikeName(dynamic.getNikeName());
        vo.setCreatedTime(dynamic.getCreatedTime().getTime());
        vo.setUpdateTime(dynamic.getUpdateTime().getTime());
        vo.setStatus(dynamic.getStatus());

        return vo;
    }

    public static DynamicVo toVo(Dynamic dynamic, Content content){
        DynamicVo vo = new DynamicVo();
        vo.setId(dynamic.getId());
        vo.setUserId(dynamic.getUserId());
        vo.setNikeName(dynamic.getNikeName());
        vo.setCreatedTime(dynamic.getCreatedTime().getTime());
        vo.setUpdateTime(dynamic.getUpdateTime().getTime());
        vo.setStatus(dynamic.getStatus());

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
        dynamic.setCreatedTime(new Date(vo.getCreatedTime()));
        dynamic.setUpdateTime(new Date(vo.getUpdateTime()));
        dynamic.setStatus(vo.getStatus());
        return dynamic;
    }
}
