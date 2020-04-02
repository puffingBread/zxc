package com.bread.enlighten.zxc.repository.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.enlighten.zxc.repository.blog.dto.RewardDTO;
import com.bread.enlighten.zxc.repository.blog.model.Reward;

import java.util.List;

public interface RewardService extends IService<Reward> {

    Long save(RewardDTO rewardDTO);

    void delete(Long id);

    void deleteByDynamicId(Long dynamicId);

    List<RewardDTO> getByDynamicId(Long dynamicId);

}
