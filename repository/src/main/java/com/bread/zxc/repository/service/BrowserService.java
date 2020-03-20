package com.bread.zxc.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bread.zxc.repository.dto.BrowserDTO;
import com.bread.zxc.repository.model.Browser;

import java.util.List;

public interface BrowserService extends IService<Browser> {

    Long save(BrowserDTO browserVo);

    void delete(Long browserId);

    void deleteByDynamicId(Long dynamicId);

    List<BrowserDTO> getByDynamicId(Long dynamicId);

}
