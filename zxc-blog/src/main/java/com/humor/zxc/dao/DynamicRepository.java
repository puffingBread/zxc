package com.humor.zxc.dao;

import com.humor.zxc.model.Dynamic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 动态
 */
public interface DynamicRepository extends JpaRepository<Dynamic, Long> {

    Dynamic findByIdAndStatus(Long id, Integer status);

    List<Dynamic> findByUserIdAndStatus(Long userId, Integer status);

    @Query("select d from Dynamic d where d.updateTime >= :startTime and d.updateTime <= :endTime")
    List<Dynamic> findByUpdateTime(Date startTime, Date endTime);
}
