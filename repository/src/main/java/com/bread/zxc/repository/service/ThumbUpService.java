package com.bread.zxc.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.zxc.repository.dto.ThumbUpDTO;
import com.bread.zxc.repository.model.ThumbUp;

import java.util.List;

public interface ThumbUpService extends IService<ThumbUp> {

    Long save(ThumbUpDTO thumbUpVo);

    void delete(Long id);

    void deleteByDynamicId(Long dynamicId);

    List<ThumbUpDTO> getByDynamicId(Long dynamicId);
}
