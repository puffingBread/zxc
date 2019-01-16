package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.service.DynamicService;
import com.puffingBread.zxc.vo.DynamicVo;
import com.puffingBread.zxc.vo.RspVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@RestController
public class DynamicController {

    private Logger logger = LoggerFactory.getLogger(DynamicController.class);

    @Autowired
    private DynamicService dynamicService;

    @RequestMapping(value = "/dynamic", method = RequestMethod.POST)
    public RspVo<DynamicVo> create(@RequestBody DynamicVo dynamicVo) {

        DynamicVo vo = null;
        try {
            vo = dynamicService.save(dynamicVo);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(-1, e.getLocalizedMessage());
        }

        return new RspVo<>(vo);
    }

    @RequestMapping(value = "/dynamic/{dynamicId}", method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable("dynamicId") Long dynamicId, Long userId) {

        try {
            dynamicService.delete(dynamicId, userId);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(-1, e.getLocalizedMessage());
        }

        return new RspVo<>();
    }

    @RequestMapping(value = "/dynamic", method = RequestMethod.GET)
    public RspVo<DynamicVo> getDynamicById(Long dynamicId) {


        return new RspVo<>(0, "malefoleng");
    }

    @RequestMapping(value = "/dynamic/user/{userId}", method = RequestMethod.GET)
    public RspVo<List<DynamicVo>> getByUserId(@PathVariable("userId") Long userId) {

        List<DynamicVo> dynamicVoList = dynamicService.getByUserId(userId);
        return new RspVo<>(dynamicVoList);
    }



}
