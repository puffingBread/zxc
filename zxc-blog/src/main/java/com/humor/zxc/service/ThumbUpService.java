package com.humor.zxc.service;

import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.vo.ThumbUpVo;

import java.util.List;

public interface ThumbUpService {

    ThumbUpVo save(ThumbUpVo thumbUpVo) throws ReadMessageException;

    void delete(Long id) throws ReadMessageException;

    void deleteByDynamicId(Long dynamicId) throws ReadMessageException;

    List<ThumbUpVo> getByDynamicId(Long dynamicId) throws ReadMessageException;
}
