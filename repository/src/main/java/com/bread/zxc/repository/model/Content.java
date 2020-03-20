package com.bread.zxc.repository.model;

import lombok.Data;

/**
 * Created by Administrator on 2017/8/4.
 */
@Data
public class Content {
    private Long id;
    private Integer contentType;
    private String title;
    private String content;
    private Integer status;
}
