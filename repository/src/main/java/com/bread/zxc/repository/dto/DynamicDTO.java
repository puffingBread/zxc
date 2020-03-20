package com.bread.zxc.repository.dto;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author Administrator
 * @date 2017/8/3
 */
@Data
public class DynamicDTO {

    private Long id;
    private Long userId;
    private String nikeName;
    private Long contentId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

}
