package com.humor.zxc.service;

import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.vo.RewardVo;

import java.util.List;

public interface RewardService {

    RewardVo save(RewardVo rewardVo) throws ReadMessageException;

    void delete(Long id) throws ReadMessageException;

    void deleteByDynamicId(Long dynamicId) throws ReadMessageException;

    List<RewardVo> getByDynamicId(Long dynamicId) throws ReadMessageException;

}
