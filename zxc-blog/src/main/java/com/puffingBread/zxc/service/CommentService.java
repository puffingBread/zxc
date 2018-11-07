package com.puffingBread.zxc.service;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.vo.CommentVo;
import com.puffingBread.zxc.vo.PageVo;

public interface CommentService {

    CommentVo save(CommentVo commentVo) throws ReadMessageException;

    void deleteById(Long id) throws ReadMessageException;

    PageVo<CommentVo> findByDynamicId(Long dynamicId, Integer pageNum, Integer pageSize) throws ReadMessageException;

    PageVo<CommentVo> findByUserId(Long userId, Integer pageNum, Integer pageSize) throws ReadMessageException;

}
