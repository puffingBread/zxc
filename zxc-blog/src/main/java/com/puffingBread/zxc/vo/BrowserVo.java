package com.puffingBread.zxc.vo;

import com.puffingBread.zxc.model.Browser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BrowserVo {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;
    private Integer status;

    public static BrowserVo toVo(Browser browser) {
        if (browser == null) {
            return null;
        }

        BrowserVo browserVo = new BrowserVo();
        browserVo.setId(browser.getId());
        browserVo.setDynamicId(browser.getDynamicId());
        browserVo.setUserId(browser.getUserId());
        browserVo.setCreatedTime(browser.getCreatedTime());
        browserVo.setUpdateTime(browser.getUpdateTime());
        browserVo.setStatus(browser.getStatus());

        return browserVo;
    }

    public static Browser toModel(BrowserVo browserVo) {
        if (browserVo == null) {
            return null;
        }

        Browser browser = new Browser();
        browser.setId(browserVo.getId());
        browser.setDynamicId(browserVo.getDynamicId());
        browser.setUserId(browserVo.getUserId());
        browser.setCreatedTime(browserVo.getCreatedTime());
        browser.setUpdateTime(browserVo.getUpdateTime());
        browser.setStatus(browserVo.getStatus());

        return browser;
    }

    public static List<BrowserVo> toVoList(List<Browser> browsers) {
        if (browsers == null) {
            return new ArrayList<>(0);
        }

        return browsers.stream().map(BrowserVo::toVo).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
