package com.bread.enlighten.zxc.repository.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.enlighten.zxc.repository.blog.dto.DynamicDTO;
import com.bread.enlighten.zxc.repository.blog.model.Dynamic;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface DynamicService extends IService<Dynamic> {

    Long save(DynamicDTO dynamicDTO);

    void delete(Long dynamicId, Long userId);

    DynamicDTO getById(Long dynamicId);

    List<DynamicDTO> getByUserId(Long userId);

    List<DynamicDTO> getByTime(Long startTime, Long endTime);
}
