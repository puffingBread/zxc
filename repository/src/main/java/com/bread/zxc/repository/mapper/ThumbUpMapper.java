package com.bread.zxc.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bread.zxc.repository.model.ThumbUp;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 * 点赞
 */
public interface ThumbUpMapper extends BaseMapper<ThumbUp> {

    ThumbUp findByIdAndStatus(Long id, Integer status);

    List<ThumbUp> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamicId, Integer status);
}
