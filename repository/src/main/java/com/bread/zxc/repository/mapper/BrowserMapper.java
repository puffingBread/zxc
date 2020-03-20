package com.bread.zxc.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bread.zxc.repository.model.Browser;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2017/8/3
 * 浏览
 */
public interface BrowserMapper extends BaseMapper<Browser> {

    List<Browser> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Browser findByIdAndStatus(Long id, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamicId, Integer status);
}
