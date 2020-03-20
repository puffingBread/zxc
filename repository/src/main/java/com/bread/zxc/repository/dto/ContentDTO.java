package com.bread.zxc.repository.dto;

import lombok.Data;

/**
 * Created by Administrator on 2017/8/4.
 */
@Data
public class ContentDTO {
    private Long id;
    private Integer contentType;
    private String title;
    private String content;
    private Integer status;
}
