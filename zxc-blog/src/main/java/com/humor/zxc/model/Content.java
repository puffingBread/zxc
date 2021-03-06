package com.humor.zxc.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/4.
 */
@Entity
public class Content {
    private Long id;
    private Integer contentType;
    private String title;
    private String content;
    private Integer status;

    @Id
    @TableGenerator(name = "PKGenerator",
            table = "id_holder",
            pkColumnName = "id_name",
            valueColumnName = "id_counter",
            pkColumnValue = "ContentId",
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
    @Column(name = "content_type", nullable = false)
    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
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

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
