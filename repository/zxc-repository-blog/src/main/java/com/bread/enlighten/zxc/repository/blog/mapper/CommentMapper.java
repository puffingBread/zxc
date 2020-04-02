package com.bread.enlighten.zxc.repository.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bread.enlighten.zxc.repository.blog.model.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 评论
 */
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamic, Integer status);

    Comment findByIdAndStatus(Long id, Integer status);

}
