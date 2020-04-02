package com.bread.enlighten.zxc.repository.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bread.enlighten.zxc.repository.blog.mapper.*;
import com.bread.enlighten.zxc.repository.blog.service.DynamicService;
import com.bread.enlighten.zxc.repository.mapper.*;
import com.bread.enlighten.zxc.repository.blog.dto.DynamicDTO;
import com.bread.zxc.repository.mapper.*;
import net.zxc.vayne.integrate.repository.mapper.*;
import com.bread.enlighten.zxc.repository.blog.model.Dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@Service
@Transactional
public class DynamicServiceImpl extends ServiceImpl<DynamicMapper, Dynamic> implements DynamicService {

    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private ThumbUpMapper thumbUpMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private RetweetMapper retweetMapper;
    @Autowired
    private BrowserMapper browserMapper;
    @Autowired
    private RewardMapper rewardMapper;

    @Override
    public Long save(DynamicDTO dynamicVo) {
//        if (dynamicVo == null) {
//            throw new ReadMessageException("dynamicVo can not be null!");
//        }
//
//        ContentVo contentVo = dynamicVo.getContent();
//        if (contentVo == null) {
//            throw new ReadMessageException("contentVo can not be null!");
//        }
//
//        Content content = ContentVo.toModel(contentVo);
//        Content resContent = contentRepository.save(content);
//
//        Dynamic dynamic = DynamicVo.toModel(dynamicVo);
//        dynamic.setContentId(resContent.getId());
//        Dynamic resDynamic = dynamicRepository.save(dynamic);
//        return DynamicVo.toVo(resDynamic, resContent);
        return null;
    }

    @Override
    public void delete(Long dynamicId, Long userId) {
//        if (dynamicId == null) {
//            throw new ReadMessageException("dynamicId can not be null!");
//        }
//        if (userId == null) {
//            throw new ReadMessageException("userId can not be null");
//        }
//
//        Dynamic dynamic = dynamicRepository.findOne(dynamicId);
//        if (dynamic == null) {
//            throw new ReadMessageException("can not found dynamic!");
//        }
//
//        dynamic.setStatus(-2);
//
//        dynamicRepository.save(dynamic);
    }

    @Override
    public DynamicDTO getById(Long dynamicId) {
//        if (dynamicId == null) {
//            throw new ReadMessageException("dynamicId can not be null!");
//        }
//
//        Dynamic dynamic = dynamicRepository.findByIdAndStatus(dynamicId, 0);
//        if (dynamic == null) {
//            throw new ReadMessageException("该动态已经被删除");
//        }
//
//        Content content = contentRepository.findByIdAndStatus(dynamic.getContentId(), 0);
//        if (content == null) {
//            throw new ReadMessageException("该动态已经被删除");
//        }
//
//        DynamicVo dynamicVo = DynamicVo.toVo(dynamic, content);
//
//        Integer thumpUpCount = thumbUpRepository.countByDynamicIdAndStatus(dynamicId, 0);
//        dynamicVo.setThumbUpCount(thumpUpCount);
//
//        Integer commentCount = commentRepository.countByDynamicIdAndStatus(dynamicId, 0);
//        dynamicVo.setCommentCount(commentCount == null ? 0 : commentCount);
//
//        Integer retweetCount = retweetRepository.countByDynamicIdAndStatus(dynamicId, 0);
//        dynamicVo.setRetweetCount(retweetCount == null ? 0 : retweetCount);
//
//        Integer browserCount = browserRepository.countByDynamicIdAndStatus(dynamicId, 0);
//        dynamicVo.setBrowserCount(browserCount == null ? 0 : browserCount);
//
//        Integer rewardCount = rewardRepository.countByDynamicIdAndStatus(dynamicId, 0);
//        dynamicVo.setRewardCount(rewardCount);
//
//        return dynamicVo;
        return null;
    }

    @Override
    public List<DynamicDTO> getByUserId(Long userId) {
//        Assert.notNull(userId);
//
//        List<Dynamic> dynamicList = dynamicRepository.findByUserIdAndStatus(userId, 0);
//        List<DynamicVo> dynamicVos = dynamicList
//                .stream()
//                .map(DynamicVo::toVo)
//                .collect(Collectors.toList());
//
//        List<Long> contentIds = dynamicList
//                .stream()
//                .map(Dynamic::getContentId)
//                .collect(Collectors.toList());
//
//        List<Content> contentList = contentRepository.findByIdIn(contentIds);
//
//        Map<Long, ContentVo> contentVoMap = contentList
//                .stream()
//                .collect(Collectors.toMap(Content::getId, ContentVo::toVo));
//
//        dynamicVos
//                .forEach(dynamicVo -> dynamicVo.setContent(contentVoMap.get(dynamicVo.getId())));
//
//        return dynamicVos;
        return null;
    }

    @Override
    public List<DynamicDTO> getByTime(Long startTime, Long endTime) {
        return null;
    }


}
