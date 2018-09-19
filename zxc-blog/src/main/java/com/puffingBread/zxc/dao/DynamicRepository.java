package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.Dynamic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 动态
 */
public interface DynamicRepository extends JpaRepository<Dynamic, Long> {

    @Query("select d from Dynamic d where d.userId = :userId")
    List<Dynamic> findByUserId(@Param("userId") Long userId);

    @Query("select d from Dynamic d where d.updateTime >= :startTime and d.updateTime <= :endTime")
    List<Dynamic> findByUpdateTime(Date startTime, Date endTime);
}
