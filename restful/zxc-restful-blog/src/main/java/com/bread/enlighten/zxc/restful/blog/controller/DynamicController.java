package com.bread.enlighten.zxc.restful.blog.controller;

import com.bread.enlighten.zxc.common.utils.BeanUtils;
import com.bread.enlighten.zxc.repository.blog.dto.DynamicDTO;
import com.bread.enlighten.zxc.repository.blog.service.DynamicService;
import com.bread.enlighten.zxc.restful.blog.vo.DynamicVO;
import com.bread.enlighten.zxc.restful.blog.vo.RspVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuzz
 */
@RestController
@Log4j2
public class DynamicController {

    @Resource
    private DynamicService dynamicService;

    @RequestMapping(value = "/dynamic", method = RequestMethod.POST)
    public RspVo<Long> create(@RequestBody DynamicVO dynamicVo) {

        DynamicDTO dynamicDTO = BeanUtils.copyProperties(dynamicVo, DynamicDTO::new);
        Long id = dynamicService.save(dynamicDTO);
        return new RspVo<>(id);
    }

    @RequestMapping(value = "/dynamic/{dynamicId}", method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable("dynamicId") Long dynamicId, Long userId) {

        dynamicService.delete(dynamicId, userId);
        return new RspVo<>();
    }

    @RequestMapping(value = "/dynamic/{dynamicId}", method = RequestMethod.GET)
    public RspVo<DynamicVO> getDynamicById(@PathVariable Long dynamicId) {

        DynamicDTO dynamicDTO = dynamicService.getById(dynamicId);
        return new RspVo<>(BeanUtils.copyProperties(dynamicDTO, DynamicVO::new));
    }

    @RequestMapping(value = "/dynamic/user/{userId}", method = RequestMethod.GET)
    public RspVo<List<DynamicVO>> getByUserId(@PathVariable("userId") Long userId) {

        List<DynamicDTO> dynamicDTOList = dynamicService.getByUserId(userId);
        return new RspVo<>(BeanUtils.convert(dynamicDTOList, DynamicVO::new));
    }

}
