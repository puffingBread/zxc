package com.humor.zxc.dao;

import com.humor.zxc.model.ThumbUp;
import org.springframework.data.jpa.repository.JpaRepository;

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
