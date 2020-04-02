package com.bread.enlighten.zxc.restful.blog.controller;

import com.bread.enlighten.zxc.common.utils.BeanUtils;
import com.bread.enlighten.zxc.repository.blog.dto.CommentDTO;
import com.bread.enlighten.zxc.repository.blog.service.CommentService;
import com.bread.enlighten.zxc.restful.blog.vo.CommentVO;
import com.bread.enlighten.zxc.restful.blog.vo.PageVo;
import com.bread.enlighten.zxc.restful.blog.vo.RspVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xuzz
 */
@RestController
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public RspVo<Long> save(CommentVO commentVO) {

        CommentDTO commentDTO = BeanUtils.copyProperties(commentVO, CommentDTO::new);
        Long id = commentService.save(commentDTO);
        return new RspVo<>(id);
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable("commentId") Long commentId) {

        commentService.deleteById(commentId);
        return new RspVo<>();
    }

    @RequestMapping(value = "/comment/dynamic/{dynamicId}", method = RequestMethod.GET)
    public RspVo<PageVo<CommentVO>> findByDynamicId(@PathVariable("dynamicId") Long dynamicId, Integer pageNum, Integer pageSize) {

        PageInfo<CommentDTO> pageVo = commentService.findByDynamicId(dynamicId, pageNum, pageSize);
        return new RspVo<>();
    }

    @RequestMapping(value = "/comment/user/{userId}", method = RequestMethod.GET)
    public RspVo<PageVo<CommentVO>> findByUserId(@PathVariable("userId") Long userId, Integer pageNum, Integer pageSize) {

        PageInfo<CommentDTO> pageVo = commentService.findByUserId(userId, pageNum, pageSize);
        return new RspVo<>();
    }

}
