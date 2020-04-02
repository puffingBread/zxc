package com.bread.enlighten.zxc.repository.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bread.enlighten.zxc.repository.blog.dto.BrowserDTO;
import com.bread.enlighten.zxc.repository.blog.mapper.BrowserMapper;
import com.bread.enlighten.zxc.repository.blog.model.Browser;
import com.bread.enlighten.zxc.repository.blog.service.BrowserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrowserServiceImpl extends ServiceImpl<BrowserMapper, Browser> implements BrowserService {

    @Autowired
    BrowserMapper browserMapper;

    @Override
    public Long save(BrowserDTO browserVo) {

        Browser browser = new Browser();
        BeanUtils.copyProperties(browserVo, browser);
        this.save(browser);

        return browser.getId();
    }

    @Override
    public void delete(Long browserId) {

        this.removeById(browserId);
    }

    @Override
    public void deleteByDynamicId(Long dynamicId) {

        LambdaQueryWrapper<Browser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Browser::getDynamicId, dynamicId);
        this.remove(lambdaQueryWrapper);
    }

    @Override
    public List<BrowserDTO> getByDynamicId(Long dynamicId) {
        List<Browser> browserList = browserMapper.findByDynamicIdAndStatus(dynamicId, 0);
        if (CollectionUtils.isEmpty(browserList)) {
            return new ArrayList<>(0);
        }

        browserList.forEach(browser -> BeanUtils.copyProperties(browser, new BrowserDTO()));
        return null;
    }
}
