package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.dao.*;
import com.puffingBread.zxc.model.Content;
import com.puffingBread.zxc.model.Dynamic;
import com.puffingBread.zxc.service.DynamicService;
import com.puffingBread.zxc.vo.ContentVo;
import com.puffingBread.zxc.vo.DynamicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/8/4.
 */
@Service
@Transactional
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    private DynamicRepository dynamicRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private ThumbUpRepository thumbUpRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RetweetRepository retweetRepository;
    @Autowired
    private BrowserRepository browserRepository;
    @Autowired
    private RewardRepository rewardRepository;

    @Override
    public DynamicVo save(DynamicVo dynamicVo) throws ReadMessageException {
        if (dynamicVo == null) {
            throw new ReadMessageException("dynamicVo can not be null!");
        }

        ContentVo contentVo = dynamicVo.getContent();
        if (contentVo == null) {
            throw new ReadMessageException("contentVo can not be null!");
        }

        Content content = ContentVo.toModel(contentVo);
        Content resContent = contentRepository.save(content);

        Dynamic dynamic = DynamicVo.toModel(dynamicVo);
        Dynamic resDynamic = dynamicRepository.save(dynamic);
        return DynamicVo.toVo(resDynamic, resContent);
    }

    @Override
    public void delete(Long dynamicId, Long userId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null!");
        }
        if (userId == null) {
            throw new ReadMessageException("userId can not be null");
        }

        Dynamic dynamic = dynamicRepository.findOne(dynamicId);
        if (dynamic == null) {
            throw new ReadMessageException("can not found dynamic!");
        }

        dynamic.setStatus(-2);

        dynamicRepository.save(dynamic);
    }

    @Override
    public DynamicVo getById(Long dynamicId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null!");
        }

        Dynamic dynamic = dynamicRepository.findByIdAndStatus(dynamicId, 0);
        if (dynamic == null) {
            throw new ReadMessageException("该动态已经被删除");
        }

        Content content = contentRepository.findByIdAndStatus(dynamic.getContentId(), 0);
        if (dynamic == null) {
            throw new ReadMessageException("该动态已经被删除");
        }

        DynamicVo dynamicVo = DynamicVo.toVo(dynamic, content);

        Integer thumpUpCount = thumbUpRepository.countByDynamicIdAndStatus(dynamicId, 0);
        dynamicVo.setThumbUpCount(thumpUpCount);

        Integer commentCount = commentRepository.countByDynamicIdAndStatus(dynamicId, 0);
        dynamicVo.setCommentCount(commentCount == null ? 0 : commentCount);

        Integer retweetCount = retweetRepository.countByDynamicIdAndStatus(dynamicId, 0);
        dynamicVo.setRetweetCount(retweetCount == null ? 0 : retweetCount);

        Integer browserCount = browserRepository.countByDynamicIdAndStatus(dynamicId, 0);
        dynamicVo.setBrowserCount(browserCount == null ? 0 : browserCount);

        Integer rewardCount = rewardRepository.countByDynamicIdAndStatus(dynamicId, 0);
        dynamicVo.setRewardCount(rewardCount);

        return dynamicVo;
    }

    @Override
    public List<DynamicVo> getByUserId(Long userId) {
        Assert.notNull(userId);

        List<Dynamic> dynamicList = dynamicRepository.findByUserIdAndStatus(userId, 0);
        List<DynamicVo> dynamicVos = dynamicList
                .stream()
                .map(DynamicVo::toVo)
                .collect(Collectors.toList());

        List<Long> contentIds = dynamicList
                .stream()
                .map(Dynamic::getContentId)
                .collect(Collectors.toList());

        List<Content> contentList = contentRepository.findByIdIn(contentIds);

        Map<Long, ContentVo> contentVoMap = contentList
                .stream()
                .collect(Collectors.toMap(Content::getId, ContentVo::toVo));

        dynamicVos
                .forEach(dynamicVo -> dynamicVo.setContent(contentVoMap.get(dynamicVo.getId())));

        return dynamicVos;
    }

    @Override
    public List<DynamicVo> getByTime(Long startTime, Long endTime) {
        return null;
    }


}
