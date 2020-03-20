package com.bread.zxc.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/4.
 */
@Data
public class DynamicVo implements Serializable {
    private Long id;
    private Long userId;
    private String nikeName;
    private ContentVo content;
    private Long createdTime;
    private Long updateTime;

    private Integer browserCount;
    private Integer commentCount;
    private Integer retweetCount;
    private Integer thumbUpCount;
    private Integer rewardCount;



}
