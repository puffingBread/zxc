package com.bread.zxc.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bread.zxc.repository.model.Reward;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 * 打赏
 */
public interface RewardMapper extends BaseMapper<Reward> {

    List<Reward> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamicId, Integer status);

    Reward findByIdAndStatus(Long id, Integer status);
}
