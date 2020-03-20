package com.bread.zxc.repository.dto;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2017/8/3
 */
@Data
public class BrowserDTO {
    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

}
