package com.bread.enlighten.zxc.restful.blog.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/4.
 */
@Data
public class DynamicVO implements Serializable {
    private Long id;
    private Long userId;
    private String nikeName;
    private ContentVO content;
    private Long createdTime;
    private Long updateTime;

    private Integer browserCount;
    private Integer commentCount;
    private Integer retweetCount;
    private Integer thumbUpCount;
    private Integer rewardCount;



}
