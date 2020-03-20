package com.bread.zxc.repository.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/3.
 */
@Data
public class Retweet {
    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

}
