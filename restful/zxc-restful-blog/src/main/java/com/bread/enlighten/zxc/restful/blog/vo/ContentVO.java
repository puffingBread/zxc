package com.bread.enlighten.zxc.restful.blog.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/4.
 */
@Data
public class ContentVO implements Serializable {

    private Long id;
    private Integer contentType;
    private String title;
    private String content;


}

