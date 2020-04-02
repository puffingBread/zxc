package com.bread.enlighten.zxc.repository.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.enlighten.zxc.repository.blog.dto.RetweetDTO;
import com.bread.enlighten.zxc.repository.blog.model.Retweet;

import java.util.List;

public interface RetweetService extends IService<Retweet> {

    Long save(RetweetDTO retweetDTO);

    void delete(Long id);

    void deleteDynamicId(Long dynamicId);

    List<RetweetDTO> getByDynamicId(Long dynamicId);

}
