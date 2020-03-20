package com.bread.zxc.repository.model;

import lombok.Data;

import java.sql.Date;

/**
 * Created by Administrator on 2017/8/3.
 */
@Data
public class ThumbUp {
    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

}
