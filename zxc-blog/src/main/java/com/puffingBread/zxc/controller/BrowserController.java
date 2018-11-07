package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.common.controller.Code;
import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.service.BrowserService;
import com.puffingBread.zxc.vo.BrowserVo;
import com.puffingBread.zxc.vo.RspVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/browser")
public class BrowserController {

    @Autowired
    BrowserService browserService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RspVo<BrowserVo> save(@RequestBody BrowserVo browserVo) {

        BrowserVo save = null;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable("id") Long id) {

        try {
            browserService.delete(id);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>();
    }
}
