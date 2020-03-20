package com.bread.zxc.vo;


import lombok.Data;

import java.util.Date;

@Data
public class BrowserVo {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;

}
