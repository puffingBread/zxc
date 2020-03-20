package com.bread.zxc.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bread.zxc.repository.dto.RewardDTO;
import com.bread.zxc.repository.mapper.RewardMapper;
import com.bread.zxc.repository.model.Reward;
import com.bread.zxc.repository.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardServiceImpl extends ServiceImpl<RewardMapper, Reward> implements RewardService {

    @Autowired
    RewardMapper rewardMapper;

    @Override
    public Long save(RewardDTO rewardVo) {
//        if (rewardVo == null) {
//            throw new ReadMessageException("rewardVo can not be null");
//        }
//
//        Reward reward = rewardRepository.save(RewardVo.toModel(rewardVo));
//
//        return RewardVo.toVo(reward);
        return null;
    }

    @Override
    public void delete(Long id) {
//        if (id == null) {
//            throw new ReadMessageException("id can not be null");
//        }
//
//        Reward reward = rewardRepository.findByIdAndStatus(id, 0);
//        if (reward == null) {
//            throw new ReadMessageException("reward can not be null");
//        }
//
//        reward.setStatus(-2);
//        rewardRepository.save(reward);
    }

    @Override
    public void deleteByDynamicId(Long dynamicId) {
//        if (dynamicId == null) {
//            throw new ReadMessageException("dynamicId can not be null");
//        }
//
//        List<Reward> rewardList = rewardRepository.findByDynamicIdAndStatus(dynamicId, 0);
//
//        rewardList
//                .forEach(reward -> reward.setStatus(-2));
//
//        rewardRepository.save(rewardList);
    }

    @Override
    public List<RewardDTO> getByDynamicId(Long dynamicId) {
//        if (dynamicId == null) {
//            throw new ReadMessageException("dynamicId can not be null");
//        }
//
//        List<Reward> rewardList = rewardRepository.findByDynamicIdAndStatus(dynamicId, 0);
//
//        List<RewardVo> rewardVoList = rewardList
//                .stream()
//                .map(RewardVo::toVo)
//                .collect(Collectors.toList());
//
//        return rewardVoList;
        return null;
    }
}
