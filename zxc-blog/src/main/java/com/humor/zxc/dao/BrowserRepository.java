package com.humor.zxc.dao;

import com.humor.zxc.model.Browser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 浏览
 */
public interface BrowserRepository extends JpaRepository<Browser, Long> {

    List<Browser> findByDynamicIdAndStatus(Long dynamicId, Integer status);

    Browser findByIdAndStatus(Long id, Integer status);

    Integer countByDynamicIdAndStatus(Long dynamicId, Integer status);
}
