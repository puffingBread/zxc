package com.bread.enlighten.zxc.restful.blog.controller;


import com.bread.enlighten.zxc.common.utils.BeanUtils;
import com.bread.enlighten.zxc.repository.blog.dto.ThumbUpDTO;
import com.bread.enlighten.zxc.repository.blog.service.ThumbUpService;
import com.bread.enlighten.zxc.restful.blog.vo.RspVo;
import com.bread.enlighten.zxc.restful.blog.vo.ThumbUpVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuzz
 */
@RestController
public class ThumbUpController {

    @Resource
    private ThumbUpService thumbUpService;

    @RequestMapping(value = "/thumbUp", method = RequestMethod.POST)
    public RspVo<Long> save(@RequestBody ThumbUpVO thumbUpVo) {

        ThumbUpDTO thumbUpDTO = BeanUtils.copyProperties(thumbUpVo, ThumbUpDTO::new);
        Long id = thumbUpService.save(thumbUpDTO);
        return new RspVo<>(id);
    }

    @RequestMapping(value = "/thumbUp/cancel", method = RequestMethod.DELETE)
    public RspVo<Object> delete(Long thumbUpId) {

        thumbUpService.delete(thumbUpId);
        return new RspVo<>();
    }

    @RequestMapping(value = "/thumbUp/dynamic/{dynamicId}", method = RequestMethod.DELETE)
    public RspVo<List<ThumbUpVO>> getByDynamicId(@PathVariable("dynamicId") Long dynamicId) {

        List<ThumbUpDTO> thumbUpList = thumbUpService.getByDynamicId(dynamicId);
        return new RspVo<>(BeanUtils.convert(thumbUpList, ThumbUpVO::new));
    }
}
