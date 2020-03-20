package com.bread.zxc.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bread.zxc.repository.model.Content;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 目录
 */
public interface ContentMapper extends BaseMapper<Content> {

    Content findByIdAndStatus(Long id, Integer status);

    List<Content> findByIdIn(List<Long> contentIds);
}
