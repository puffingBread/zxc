package com.bread.enlighten.zxc.restful.blog.controller;

import com.bread.enlighten.zxc.common.utils.BeanUtils;
import com.bread.enlighten.zxc.repository.blog.dto.RewardDTO;
import com.bread.enlighten.zxc.repository.blog.service.RewardService;
import com.bread.enlighten.zxc.restful.blog.vo.RewardVO;
import com.bread.enlighten.zxc.restful.blog.vo.RspVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuzz
 */
@RestController
public class RewardController {

    @Resource
    private RewardService rewardService;

    @RequestMapping(value = "/reward", method = RequestMethod.POST)
    public RspVo<Long> save(RewardVO rewardVo) {

        RewardDTO rewardDTO = BeanUtils.copyProperties(rewardVo, RewardDTO::new);
        Long save = rewardService.save(rewardDTO);
        return new RspVo<>(save);
    }


    @RequestMapping(value = "/reward/{rewardId}", method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable("rewardId") Long rewardId) {

        rewardService.delete(rewardId);
        return new RspVo<>();
    }

    @RequestMapping(value = "/reward/dynamic/{dynamicId}", method = RequestMethod.DELETE)
    public RspVo<Object> deleteByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        rewardService.deleteByDynamicId(dynamicId);
        return new RspVo<>();
    }

    @RequestMapping(value = "/reward/dynamic/{dynamicId}", method = RequestMethod.GET)
    public RspVo<List<RewardVO>> getByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        List<RewardDTO> rewardList = rewardService.getByDynamicId(dynamicId);
        return new RspVo<>(BeanUtils.convert(rewardList, RewardVO::new));
    }

}
