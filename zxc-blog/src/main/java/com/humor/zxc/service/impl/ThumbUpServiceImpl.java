package com.humor.zxc.service.impl;

import com.humor.zxc.common.exception.ReadMessageException;
import com.humor.zxc.dao.ThumbUpRepository;
import com.humor.zxc.model.ThumbUp;
import com.humor.zxc.service.ThumbUpService;
import com.humor.zxc.vo.ThumbUpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThumbUpServiceImpl implements ThumbUpService {

    @Autowired
    ThumbUpRepository thumbUpRepository;

    @Override
    public ThumbUpVo save(ThumbUpVo thumbUpVo) throws ReadMessageException {
        if (thumbUpVo == null) {
            throw new ReadMessageException("thumbUpVo can not be null");
        }

        ThumbUp thumbUp = ThumbUpVo.toModel(thumbUpVo);
        ThumbUp resThumbUp = thumbUpRepository.save(thumbUp);

        return ThumbUpVo.toVo(resThumbUp);
    }

    @Override
    public void delete(Long id) throws ReadMessageException {
        if (id == null) {
            throw new ReadMessageException("id can not be null");
        }

        ThumbUp thumbUp = thumbUpRepository.findByIdAndStatus(id, 0);
        if (thumbUp == null) {
            return;
        }

        thumbUp.setStatus(-2);
        thumbUpRepository.save(thumbUp);
    }

    @Override
    public void deleteByDynamicId(Long dynamicId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null");
        }

        List<ThumbUp> thumbUpList = thumbUpRepository.findByDynamicIdAndStatus(dynamicId, 0);
        if (CollectionUtils.isEmpty(thumbUpList)) {
            return;
        }

        thumbUpList
                .forEach(thumbUp -> thumbUp.setStatus(-2));

        thumbUpRepository.saveAll(thumbUpList);
    }

    @Override
    public List<ThumbUpVo> getByDynamicId(Long dynamicId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null");
        }

        List<ThumbUp> thumbUpList = thumbUpRepository.findByDynamicIdAndStatus(dynamicId, 0);
        if (CollectionUtils.isEmpty(thumbUpList)) {
            return new ArrayList<>(0);
        }

        return thumbUpList
                .stream()
                .map(ThumbUpVo::toVo)
                .collect(Collectors.toList());
    }
}
