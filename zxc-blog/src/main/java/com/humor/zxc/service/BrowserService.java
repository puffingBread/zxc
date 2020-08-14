package com.humor.zxc.service;

import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.vo.BrowserVo;

import java.util.List;

public interface BrowserService {

    BrowserVo save(BrowserVo browserVo) throws ReadMessageException;

    void delete(Long browserId) throws ReadMessageException;

    void deleteByDynamicId(Long dynamicId) throws ReadMessageException;

    List<BrowserVo> getByDynamicId(Long dynamicId) throws ReadMessageException;

}
