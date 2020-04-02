package com.bread.enlighten.zxc.restful.blog.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class ThumbUpVO {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;

}
