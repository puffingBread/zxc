package com.bread.zxc.repository.model;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2017/8/3
 */
@Data
public class Reward {
    private Long id;
    private Long dynamicId;
    private Long userId;
    private Integer amount;
    private Date createdTime;
    private Date updateTime;
    private Integer status;


}
