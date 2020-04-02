package com.bread.enlighten.zxc.restful.blog.vo;


import lombok.Data;

import java.util.Date;

/**
 * @author xuzz
 */
@Data
public class BrowserVO {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;

}
