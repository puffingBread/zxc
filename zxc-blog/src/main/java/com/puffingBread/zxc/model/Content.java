package com.puffingBread.zxc.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/8/4.
 */
@Entity
public class Content {
    private long dynamicId;
    private int contentType;
    private String title;
    private String content;
    private long id;

    @Basic
    @Column(name = "dynamic_id", nullable = false)
    public long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(long dynamicId) {
        this.dynamicId = dynamicId;
    }

    @Basic
    @Column(name = "content_type", nullable = false)
    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 128)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content content1 = (Content) o;

        if (dynamicId != content1.dynamicId) return false;
        if (contentType != content1.contentType) return false;
        if (id != content1.id) return false;
        if (title != null ? !title.equals(content1.title) : content1.title != null) return false;
        if (content != null ? !content.equals(content1.content) : content1.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dynamicId ^ (dynamicId >>> 32));
        result = 31 * result + contentType;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
