package com.puffingBread.zxc.service;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.vo.RetweetVo;

import java.util.List;

public interface RetweetService {

    RetweetVo save(RetweetVo retweetVo) throws ReadMessageException;

    void delete(Long id) throws ReadMessageException;

    void deleteDynamicId(Long dynamicId) throws ReadMessageException;

    List<RetweetVo> getByDynamicId(Long dynamicId) throws ReadMessageException;

}
