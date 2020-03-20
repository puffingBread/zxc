package com.bread.zxc.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.zxc.repository.dto.RewardDTO;
import com.bread.zxc.repository.model.Reward;

import java.util.List;

public interface RewardService extends IService<Reward> {

    Long save(RewardDTO rewardDTO);

    void delete(Long id);

    void deleteByDynamicId(Long dynamicId);

    List<RewardDTO> getByDynamicId(Long dynamicId);

}
