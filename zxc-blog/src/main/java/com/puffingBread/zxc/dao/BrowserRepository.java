package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.Browser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 浏览
 */
public interface BrowserRepository extends JpaRepository<Browser, Long> {

    @Query("select b from Browser b where b.dynamicId = :dynamicId")
    List<Browser> findByDynamicId(Long dynamicId);
}
