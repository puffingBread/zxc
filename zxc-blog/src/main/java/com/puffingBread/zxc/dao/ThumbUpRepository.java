package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.ThumbUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 * 点赞
 */
public interface ThumbUpRepository extends JpaRepository<ThumbUp, Long> {

    ThumbUp findByIdAndStatus(Long id, Integer status);

    List<ThumbUp> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamicId, Integer status);
}
