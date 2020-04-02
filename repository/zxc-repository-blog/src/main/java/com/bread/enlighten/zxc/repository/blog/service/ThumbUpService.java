package com.bread.enlighten.zxc.repository.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.enlighten.zxc.repository.blog.dto.ThumbUpDTO;
import com.bread.enlighten.zxc.repository.blog.model.ThumbUp;

import java.util.List;

public interface ThumbUpService extends IService<ThumbUp> {

    Long save(ThumbUpDTO thumbUpVo);

    void delete(Long id);

    void deleteByDynamicId(Long dynamicId);

    List<ThumbUpDTO> getByDynamicId(Long dynamicId);
}
