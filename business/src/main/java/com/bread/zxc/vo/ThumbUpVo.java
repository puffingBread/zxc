package com.bread.zxc.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class ThumbUpVo {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;

}
