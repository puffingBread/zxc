package com.puffingBread.zxc.service;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.vo.ThumbUpVo;

import java.util.List;

public interface ThumbUpService {

    ThumbUpVo save(ThumbUpVo thumbUpVo) throws ReadMessageException;

    void delete(Long id) throws ReadMessageException;

    void deleteByDynamicId(Long dynamicId) throws ReadMessageException;

    List<ThumbUpVo> getByDynamicId(Long dynamicId) throws ReadMessageException;

}
