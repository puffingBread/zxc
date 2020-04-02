package com.bread.enlighten.zxc.restful.blog.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RetweetVO {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;

}
