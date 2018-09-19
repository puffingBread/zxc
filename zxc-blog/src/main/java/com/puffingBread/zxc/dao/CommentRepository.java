package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 评论
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.dynamicId = :dynamicId")
    List<Comment> findByDynamicId(Long dynamicId);
}
