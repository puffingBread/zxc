package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.service.DynamicService;
import com.puffingBread.zxc.vo.DynamicVo;
import com.puffingBread.zxc.vo.RspVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@RestController
public class DynamicController {

    @Autowired
    private DynamicService dynamicService;

    @RequestMapping(value = "/dynamic", method = RequestMethod.GET)
    public RspVo<List<DynamicVo>> getByUserId(@RequestParam("userId") long userId) {
        List<DynamicVo> dynamicVoList = dynamicService.getByUserId(userId);
        return new RspVo<List<DynamicVo>>(dynamicVoList);
    }
}
