package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.dao.ContentRepository;
import com.puffingBread.zxc.dao.DynamicRepository;
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
    public boolean delete(Long dynamicId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null!");
        }

        Dynamic dynamic = dynamicRepository.findOne(dynamicId);
        if (dynamic == null) {
            throw new ReadMessageException("can not found dynamic!");
        }

        dynamic.setStatus(-2);

        dynamicRepository.save(dynamic);
        return true;
    }

    @Override
    public List<DynamicVo> getByUserId(Long userId) {
        if (userId == null) {
            Assert.isNull(userId);
        }

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
