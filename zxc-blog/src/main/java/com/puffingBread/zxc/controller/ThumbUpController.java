package com.puffingBread.zxc.controller;


import com.puffingBread.zxc.common.controller.Code;
import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.service.ThumbUpService;
import com.puffingBread.zxc.vo.RspVo;
import com.puffingBread.zxc.vo.ThumbUpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThumbUpController {

    @Autowired
    ThumbUpService thumbUpService;

    @RequestMapping(value = "/thumbUp", method = RequestMethod.POST)
    public RspVo<ThumbUpVo> save(@RequestBody ThumbUpVo thumbUpVo) {

        ThumbUpVo thumb = null;
        try {
            thumb = thumbUpService.save(thumbUpVo);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getLocalizedMessage());
        }

        if (thumb == null) {
            return new RspVo<>(Code.ERROR.code, Code.ERROR.name);
        }

        return new RspVo<>(thumb);
    }

    @RequestMapping(value = "/thumbUp/cancel", method = RequestMethod.DELETE)
    public RspVo<Object> delete(Long thumbUpId) {

        try {
            thumbUpService.delete(thumbUpId);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getLocalizedMessage());
        }

        return new RspVo<>();
    }

    @RequestMapping(value = "/thumbUp/dynamic/{dynamicId}", method = RequestMethod.DELETE)
    public RspVo<List<ThumbUpVo>> getByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        List<ThumbUpVo> thumbUpVoList;
        try {
            thumbUpVoList = thumbUpService.getByDynamicId(dynamicId);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getLocalizedMessage());
        }

        return new RspVo<>(thumbUpVoList);
    }
}
