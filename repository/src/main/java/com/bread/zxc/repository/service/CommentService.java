package com.bread.zxc.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.zxc.repository.dto.CommentDTO;
import com.bread.zxc.repository.model.Comment;
import com.github.pagehelper.PageInfo;

public interface CommentService extends IService<Comment> {

    CommentDTO save(CommentDTO commentDTO);

    void deleteById(Long id);

    PageInfo<CommentDTO> findByDynamicId(Long dynamicId, Integer pageNum, Integer pageSize);

    PageInfo<CommentDTO> findByUserId(Long userId, Integer pageNum, Integer pageSize);

}
