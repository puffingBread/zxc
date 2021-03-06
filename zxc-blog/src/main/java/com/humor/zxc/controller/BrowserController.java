package com.humor.zxc.controller;

import com.humor.zxc.common.controller.Code;
import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.service.BrowserService;
import com.humor.zxc.vo.BrowserVo;
import com.humor.zxc.vo.RspVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrowserController {

    @Autowired
    BrowserService browserService;

    @RequestMapping(value = "/browser", method = RequestMethod.POST)
    public RspVo<BrowserVo> save(@RequestBody BrowserVo browserVo) {

        BrowserVo save;
        try {
            save = browserService.save(browserVo);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        if (save == null) {
            return new RspVo<>(Code.ERROR.code, Code.ERROR.name);
        }

        return new RspVo<>(save);
    }

    @RequestMapping(value = "/browser/{id}", method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable("id") Long id) {

        try {
            browserService.delete(id);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>();
    }

    @RequestMapping(value = "/browser/dynamic/{dynamicId}", method = RequestMethod.DELETE)
    public RspVo<Object> deleteByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        try {
            browserService.deleteByDynamicId(dynamicId);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>();
    }

    @RequestMapping(value = "/browser/dynamic/{dynamicId}", method = RequestMethod.GET)
    public RspVo<List<BrowserVo>> getByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        List<BrowserVo> browserVoList;
        try {
            browserVoList = browserService.getByDynamicId(dynamicId);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>(browserVoList);
    }
}
