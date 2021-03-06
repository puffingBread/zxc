package com.humor.zxc.service;

import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.vo.DynamicVo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface DynamicService {

    DynamicVo save(DynamicVo dynamicVo) throws ReadMessageException;

    void delete(Long dynamicId, Long userId) throws ReadMessageException;

    DynamicVo getById(Long dynamicId) throws ReadMessageException;

    List<DynamicVo> getByUserId(Long userId);

    List<DynamicVo> getByTime(Long startTime, Long endTime);
}
