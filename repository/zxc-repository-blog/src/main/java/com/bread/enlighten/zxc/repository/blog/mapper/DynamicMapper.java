package com.bread.enlighten.zxc.repository.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bread.enlighten.zxc.repository.blog.model.Dynamic;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 动态
 */
public interface DynamicMapper extends BaseMapper<Dynamic> {

    Dynamic findByIdAndStatus(Long id, Integer status);

    List<Dynamic> findByUserIdAndStatus(Long userId, Integer status);

//    @Query("select d from Dynamic d where d.updateTime >= :startTime and d.updateTime <= :endTime")
    List<Dynamic> findByUpdateTime(Date startTime, Date endTime);
}
