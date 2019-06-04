package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.common.controller.Code;
import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.service.RewardService;
import com.puffingBread.zxc.vo.RewardVo;
import com.puffingBread.zxc.vo.RspVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RewardController {

    @Autowired
    RewardService rewardService;

    @RequestMapping(value = "/reward", method = RequestMethod.POST)
    public RspVo<RewardVo> save(RewardVo rewardVo) {

        RewardVo save;
        try {
            save = rewardService.save(rewardVo);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>(save);
    }


    @RequestMapping(value = "/reward/{rewardId}",method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable("rewardId") Long rewardId) {

        try {
            rewardService.delete(rewardId);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>();
    }

    @RequestMapping(value = "/reward/dynamic/{dynamicId}", method = RequestMethod.DELETE)
    public RspVo<Object> deleteByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        try {
            rewardService.deleteByDynamicId(dynamicId);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>();
    }

    @RequestMapping(value = "/reward/dynamic/{dynamicId}", method = RequestMethod.GET)
    public RspVo<List<RewardVo>> getByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        List<RewardVo> rewardVoList;
        try {
            rewardVoList = rewardService.getByDynamicId(dynamicId);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>(rewardVoList);
    }

}
