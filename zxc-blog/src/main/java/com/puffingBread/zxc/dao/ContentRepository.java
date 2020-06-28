package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 * 目录
 */
public interface ContentRepository extends JpaRepository<Content, Long> {

    Content findByIdAndStatus(Long id, Integer status);

    List<Content> findByIdIn(List<Long> contentIds);
}
