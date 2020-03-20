package com.bread.zxc.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RetweetVo {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;

}
