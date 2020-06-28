package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 评论
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamic, Integer status);

    Comment findByIdAndStatus(Long id, Integer status);

    Page<Comment> findByDynamicIdAndStatus(Long dynamicId, Integer status, Pageable pageable);

    Page<Comment> findByUserIdAndStatus(Long userId, Integer status, Pageable pageable);
}
