package com.bread.enlighten.zxc.restful.blog.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {

    private Long id;
    private Long dynamicId;
    private String content;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Long operatorId;


}
