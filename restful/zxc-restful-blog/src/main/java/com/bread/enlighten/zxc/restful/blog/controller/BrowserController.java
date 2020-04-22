package com.bread.enlighten.zxc.restful.blog.controller;

import com.bread.enlighten.zxc.common.util.utils.BeanUtils;
import com.bread.enlighten.zxc.repository.blog.dto.BrowserDTO;
import com.bread.enlighten.zxc.repository.blog.service.BrowserService;
import com.bread.enlighten.zxc.restful.blog.vo.BrowserVO;
import com.bread.enlighten.zxc.restful.blog.vo.RspVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuzz
 */
@RestController
public class BrowserController {

    @Resource
    private BrowserService browserService;

    @RequestMapping(value = "/browser", method = RequestMethod.POST)
    public RspVo<Long> save(@RequestBody BrowserVO browserVO) {

        BrowserDTO browserDTO = BeanUtils.copyProperties(browserVO, BrowserDTO::new);
        Long id = browserService.save(browserDTO);
        return new RspVo<>(id);
    }

    @RequestMapping(value = "/browser/{id}", method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable("id") Long id) {

        browserService.delete(id);
        return new RspVo<>();
    }

    @RequestMapping(value = "/browser/dynamic/{dynamicId}", method = RequestMethod.DELETE)
    public RspVo<Object> deleteByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        browserService.deleteByDynamicId(dynamicId);
        return new RspVo<>();
    }

    @RequestMapping(value = "/browser/dynamic/{dynamicId}", method = RequestMethod.GET)
    public RspVo<List<BrowserVO>> getByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        List<BrowserDTO> browserList = browserService.getByDynamicId(dynamicId);
        return new RspVo<>(BeanUtils.convert(browserList, BrowserVO::new));
    }
}
