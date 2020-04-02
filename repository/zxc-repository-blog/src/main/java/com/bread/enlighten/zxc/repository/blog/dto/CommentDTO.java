package com.bread.enlighten.zxc.repository.blog.dto;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2017/8/3
 */
@Data
public class CommentDTO {

    private Long id;
    private Long dynamicId;
    private String content;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;
    private Long operatorId;

}