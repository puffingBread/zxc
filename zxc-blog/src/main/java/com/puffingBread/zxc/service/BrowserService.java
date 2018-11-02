package com.puffingBread.zxc.service;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.vo.BrowserVo;

import java.util.List;

public interface BrowserService {

    BrowserVo save(BrowserVo browserVo) throws ReadMessageException;

    void delete(Long browserId) throws ReadMessageException;

    List<BrowserVo> getByDynamicId(Long dynamicId) throws ReadMessageException;

}
