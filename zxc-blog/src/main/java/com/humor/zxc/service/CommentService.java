package com.humor.zxc.service;

import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.vo.CommentVo;
import com.humor.zxc.vo.PageVo;

public interface CommentService {

    CommentVo save(CommentVo commentVo) throws ReadMessageException;

    void deleteById(Long id) throws ReadMessageException;

    PageVo<CommentVo> findByDynamicId(Long dynamicId, Integer pageNum, Integer pageSize) throws ReadMessageException;

    PageVo<CommentVo> findByUserId(Long userId, Integer pageNum, Integer pageSize) throws ReadMessageException;

}
