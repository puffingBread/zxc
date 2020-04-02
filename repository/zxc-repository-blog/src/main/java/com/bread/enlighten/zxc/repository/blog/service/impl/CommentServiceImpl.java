package com.bread.enlighten.zxc.repository.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bread.enlighten.zxc.repository.blog.dto.CommentDTO;
import com.bread.enlighten.zxc.repository.blog.mapper.CommentMapper;
import com.bread.enlighten.zxc.repository.blog.model.Comment;
import com.bread.enlighten.zxc.repository.blog.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuzz
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public CommentDTO save(CommentDTO commentVo) {

//        Comment comment = CommentVo.toModel(commentVo);
//        Comment resComment = commentRepository.save(comment);

        return null;
    }

    @Override
    public void deleteById(Long id) {

        this.removeById(id);
    }

    @Override
    public PageInfo<CommentDTO> findByDynamicId(Long dynamicId, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;

//        Page<Comment> page = commentRepository.findByDynamicIdAndStatus(dynamicId, 0, new PageRequest(pageNum, pageSize));
//        if (page == null || page.getTotalPages() == 0 || page.getContent() == null) {
//            return new PageVo<>(new ArrayList<>(0), 0);
//        }
//
//        List<CommentVo> commentVoList = page.getContent()
//                .stream()
//                .map(CommentVo::toVo)
//                .collect(Collectors.toList());

        return null;
    }

    @Override
    public PageInfo<CommentDTO> findByUserId(Long userId, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;

//        Page<Comment> page = commentRepository.findByUserIdAndStatus(userId, 0, new PageRequest(pageNum, pageSize));
//        if (page == null || page.getTotalPages() == 0 || page.getContent() == null) {
//            return new PageVo<>(new ArrayList<>(0), 0);
//        }
//
//        List<CommentVo> commentVoList = page.getContent()
//                .stream()
//                .map(CommentVo::toVo)
//                .collect(Collectors.toList());
//
//        return new PageVo<>(commentVoList, page.getTotalPages());
        return null;
    }
}
