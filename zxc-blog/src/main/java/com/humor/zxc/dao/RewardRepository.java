package com.humor.zxc.dao;

import com.humor.zxc.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 * 打赏
 */
public interface RewardRepository extends JpaRepository<Reward, Long> {

    List<Reward> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamicId, Integer status);

    Reward findByIdAndStatus(Long id, Integer status);
}
