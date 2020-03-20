package com.bread.zxc.controller;

import com.bread.zxc.common.controller.Code;
import com.bread.zxc.common.exception.ReadMessageException;
import com.bread.zxc.service.CommentService;
import com.bread.zxc.vo.CommentVo;
import com.bread.zxc.vo.PageVo;
import com.bread.zxc.vo.RspVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public RspVo<CommentVo> save(CommentVo commentVo) {

        CommentVo save;
        try {
            save = commentService.save(commentVo);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        if (save == null) {
            return new RspVo<>(Code.ERROR.code, Code.ERROR.name);
        }

        return new RspVo<>(save);
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable("commentId") Long commentId) {

        try {
            commentService.deleteById(commentId);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>();
    }

    @RequestMapping(value = "/comment/dynamic/{dynamicId}", method = RequestMethod.GET)
    public RspVo<PageVo<CommentVo>> findByDynamicId(@PathVariable("dynamicId") Long dynamicId, Integer pageNum, Integer pageSize) {

        PageVo<CommentVo> pageVo;
        try {
            pageVo = commentService.findByDynamicId(dynamicId, pageNum, pageSize);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>(pageVo);
    }

    @RequestMapping(value = "/comment/user/{userId}", method = RequestMethod.GET)
    public RspVo<PageVo<CommentVo>> findByUserId(@PathVariable("userId") Long userId, Integer pageNum, Integer pageSize) {

        PageVo<CommentVo> pageVo;
        try {
            pageVo = commentService.findByUserId(userId, pageNum, pageSize);
        } catch (ReadMessageException e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getMessage());
        }

        return new RspVo<>(pageVo);
    }

}
