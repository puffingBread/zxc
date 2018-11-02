package com.puffingBread.zxc.service;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.vo.DynamicVo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface DynamicService {

    DynamicVo save(DynamicVo dynamicVo) throws ReadMessageException;

    boolean delete(Long dynamicId) throws ReadMessageException;

    List<DynamicVo> getByUserId(Long userId);

    List<DynamicVo> getByTime(Long startTime, Long endTime);
}
