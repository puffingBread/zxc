package com.humor.zxc.vo;

import com.humor.zxc.model.Browser;

import java.util.Date;

public class BrowserVo {

    private Long id;
    private Long dynamicId;
    private Long userId;
    private Date createdTime;
    private Date updateTime;

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
        browser.setStatus(0);

        return browser;
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
}
