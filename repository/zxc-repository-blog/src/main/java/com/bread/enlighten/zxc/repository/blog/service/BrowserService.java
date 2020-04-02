package com.bread.enlighten.zxc.repository.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.enlighten.zxc.repository.blog.dto.BrowserDTO;
import com.bread.enlighten.zxc.repository.blog.model.Browser;

import java.util.List;

public interface BrowserService extends IService<Browser> {

    Long save(BrowserDTO browserVo);

    void delete(Long browserId);

    void deleteByDynamicId(Long dynamicId);

    List<BrowserDTO> getByDynamicId(Long dynamicId);

}
