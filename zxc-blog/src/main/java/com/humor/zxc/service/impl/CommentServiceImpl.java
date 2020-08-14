package com.humor.zxc.service.impl;

import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.dao.CommentRepository;
import com.humor.zxc.model.Comment;
import com.humor.zxc.service.CommentService;
import com.humor.zxc.vo.CommentVo;
import com.humor.zxc.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentVo save(CommentVo commentVo) throws ReadMessageException {
        if (commentVo == null) {
            throw new ReadMessageException("commentVo can not be null");
        }

        Comment comment = CommentVo.toModel(commentVo);
        Comment resComment = commentRepository.save(comment);

        return CommentVo.toVo(resComment);
    }

    @Override
    public void deleteById(Long id) throws ReadMessageException {
        if (id == null) {
            throw new ReadMessageException("id can not be null");
        }

        Comment comment = commentRepository.findByIdAndStatus(id, 0);
        if (comment == null) {
            throw new ReadMessageException("can not found comment");
        }

        comment.setStatus(-2);
        commentRepository.save(comment);
    }

    @Override
    public PageVo<CommentVo> findByDynamicId(Long dynamicId, Integer pageNum, Integer pageSize) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null");
        }

        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;

        Page<Comment> page = commentRepository.findByDynamicIdAndStatus(dynamicId, 0, PageRequest.of(pageNum, pageSize));
        if (page == null || page.getTotalPages() == 0) {
            return new PageVo<>(new ArrayList<>(0), 0);
        }

        List<CommentVo> commentVoList = page.getContent()
                .stream()
                .map(CommentVo::toVo)
                .collect(Collectors.toList());

        return new PageVo<>(commentVoList, page.getTotalPages());
    }

    @Override
    public PageVo<CommentVo> findByUserId(Long userId, Integer pageNum, Integer pageSize) throws ReadMessageException {
        if (userId == null) {
            throw new ReadMessageException("userId can not be null");
        }

        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;

        Page<Comment> page = commentRepository.findByUserIdAndStatus(userId, 0, PageRequest.of(pageNum, pageSize));
        if (page == null || page.getTotalPages() == 0) {
            return new PageVo<>(new ArrayList<>(0), 0);
        }

        List<CommentVo> commentVoList = page.getContent()
                .stream()
                .map(CommentVo::toVo)
                .collect(Collectors.toList());

        return new PageVo<>(commentVoList, page.getTotalPages());
    }
}
