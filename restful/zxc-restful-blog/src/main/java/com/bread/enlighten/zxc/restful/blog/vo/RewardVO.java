package com.bread.enlighten.zxc.restful.blog.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RewardVO {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Integer amount;
    private Date createdTime;
    private Date updateTime;

}
