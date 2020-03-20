package com.bread.zxc.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RewardVo {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Integer amount;
    private Date createdTime;
    private Date updateTime;

}
