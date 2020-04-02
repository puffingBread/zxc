package com.bread.enlighten.zxc.repository.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bread.enlighten.zxc.repository.blog.model.Retweet;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 * 转发
 */
public interface RetweetMapper extends BaseMapper<Retweet> {

    List<Retweet> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Retweet findByIdAndStatus(Long id, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamicId, Integer status);
}
