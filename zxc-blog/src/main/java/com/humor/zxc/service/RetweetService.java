package com.humor.zxc.service;

import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.vo.RetweetVo;

import java.util.List;

public interface RetweetService {

    RetweetVo save(RetweetVo retweetVo) throws ReadMessageException;

    void delete(Long id) throws ReadMessageException;

    void deleteDynamicId(Long dynamicId) throws ReadMessageException;

    List<RetweetVo> getByDynamicId(Long dynamicId) throws ReadMessageException;

}
