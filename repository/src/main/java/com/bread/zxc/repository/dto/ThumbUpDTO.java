package com.bread.zxc.repository.dto;

import lombok.Data;

import java.sql.Date;

/**
 *
 * @author Administrator
 * @date 2017/8/3
 */
@Data
public class ThumbUpDTO {
    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

}
