package com.bread.zxc.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.zxc.repository.dto.RetweetDTO;
import com.bread.zxc.repository.model.Retweet;

import java.util.List;

public interface RetweetService extends IService<Retweet> {

    Long save(RetweetDTO retweetDTO);

    void delete(Long id);

    void deleteDynamicId(Long dynamicId);

    List<RetweetDTO> getByDynamicId(Long dynamicId);

}
