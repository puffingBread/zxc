package com.bread.enlighten.zxc.repository.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.enlighten.zxc.repository.blog.dto.CommentDTO;
import com.bread.enlighten.zxc.repository.blog.model.Comment;
import com.github.pagehelper.PageInfo;

public interface CommentService extends IService<Comment> {

    Long save(CommentDTO commentDTO);

    void deleteById(Long id);

    PageInfo<CommentDTO> findByDynamicId(Long dynamicId, Integer pageNum, Integer pageSize);

    PageInfo<CommentDTO> findByUserId(Long userId, Integer pageNum, Integer pageSize);

}
