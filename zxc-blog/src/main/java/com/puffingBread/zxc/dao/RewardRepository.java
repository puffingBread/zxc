package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 * 打赏
 */
public interface RewardRepository extends JpaRepository<Reward, Long> {

    List<Reward> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Reward findByIdAndStatus(Long id, Integer status);
}
