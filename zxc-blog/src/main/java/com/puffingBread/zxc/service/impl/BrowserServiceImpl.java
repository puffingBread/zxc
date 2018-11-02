package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.dao.BrowserRepository;
import com.puffingBread.zxc.model.Browser;
import com.puffingBread.zxc.service.BrowserService;
import com.puffingBread.zxc.vo.BrowserVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BrowserServiceImpl implements BrowserService {

    @Autowired
    BrowserRepository browserRepository;

    @Override
    public BrowserVo save(BrowserVo browserVo) throws ReadMessageException {
        if (browserVo == null) {
            throw new ReadMessageException("browserVo can not be null!");
        }

        Browser browser = BrowserVo.toModel(browserVo);
        Browser resBrowser = browserRepository.save(browser);

        return BrowserVo.toVo(resBrowser);
    }

    @Override
    public void delete(Long browserId) throws ReadMessageException {
        if (browserId == null) {
            throw new ReadMessageException("browserId can not be null!");
        }

        Browser browser = browserRepository.findByIdAndStatus(browserId, 0);
        if (browser == null) {
            throw new ReadMessageException("can not found browser");
        }

        browser.setStatus(-2);
        browserRepository.save(browser);
    }

    @Override
    public List<BrowserVo> getByDynamicId(Long dynamicId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null!");
        }

        List<Browser> browserList = browserRepository.findByDynamicIdAndStatus(dynamicId, 0);

        return null;
    }
}