package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 * 转发
 */
public interface RetweetRepository extends JpaRepository<Retweet, Long> {

    List<Retweet> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Retweet findByIdAndStatus(Long id, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamicId, Integer status);
}
