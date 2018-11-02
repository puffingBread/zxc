package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.Content;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/4.
 */
public class ContentVo implements Serializable {

    private Long id;
    private Integer contentType;
    private String title;
    private String content;
    private Integer status;

    public static Content toModel(ContentVo contentVo) {
        if (contentVo == null) {
            return null;
        }

        Content content = new Content();
        content.setId(contentVo.getId());
        content.setContentType(contentVo.getContentType());
        content.setTitle(contentVo.getTitle());
        content.setContent(contentVo.getContent());
        content.setStatus(contentVo.getStatus());

        return content;
    }

    public static ContentVo toVo(Content content) {
        if (content == null) {
            return null;
        }

        ContentVo contentVo = new ContentVo();
        contentVo.setId(content.getId());
        contentVo.setContentType(content.getContentType());
        contentVo.setTitle(content.getTitle());
        contentVo.setContent(content.getContent());
        contentVo.setStatus(content.getStatus());

        return contentVo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContentVo{");
        sb.append("id=").append(id);
        sb.append(", contentType=").append(contentType);
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}

