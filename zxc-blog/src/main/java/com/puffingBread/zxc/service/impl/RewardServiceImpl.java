package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.dao.RewardRepository;
import com.puffingBread.zxc.model.Reward;
import com.puffingBread.zxc.service.RewardService;
import com.puffingBread.zxc.vo.RewardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    RewardRepository rewardRepository;

    @Override
    public RewardVo save(RewardVo rewardVo) throws ReadMessageException {
        if (rewardVo == null) {
            throw new ReadMessageException("rewardVo can not be null");
        }

        Reward reward = rewardRepository.save(RewardVo.toModel(rewardVo));
        return RewardVo.toVo(reward);
    }

    @Override
    public void delete(Long id) throws ReadMessageException {
        if (id == null) {
            throw new ReadMessageException("id can not be null");
        }

        Reward reward = rewardRepository.findByIdAndStatus(id, 0);
        if (reward == null) {
            throw new ReadMessageException("reward can not be null");
        }

        reward.setStatus(-2);
        rewardRepository.save(reward);
    }

    @Override
    public void deleteByDynamicId(Long dynamicId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null");
        }

        List<Reward> rewardList = rewardRepository.findByDynamicIdAndStatus(dynamicId, 0);

        rewardList
                .forEach(reward -> reward.setStatus(-2));

        rewardRepository.saveAll(rewardList);
    }

    @Override
    public List<RewardVo> getByDynamicId(Long dynamicId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null");
        }

        List<Reward> rewardList = rewardRepository.findByDynamicIdAndStatus(dynamicId, 0);
        return rewardList
                .stream()
                .map(RewardVo::toVo)
                .collect(Collectors.toList());
    }
}
