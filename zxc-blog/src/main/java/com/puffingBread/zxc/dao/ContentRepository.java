package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 目录
 */
public interface ContentRepository extends JpaRepository<Content, Long> {

    @Query("select c from Content c where c.dynamicId = :dynamicId")
    List<Content> findByDynamicId(Long dynamicId);

    Content findById(long id);
}
