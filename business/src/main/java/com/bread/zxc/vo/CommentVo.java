package com.bread.zxc.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVo {

    private Long id;
    private Long dynamicId;
    private String content;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Long operatorId;


}
