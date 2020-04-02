package com.bread.enlighten.zxc.repository.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bread.enlighten.zxc.repository.blog.service.ThumbUpService;
import com.bread.enlighten.zxc.repository.blog.dto.ThumbUpDTO;
import com.bread.enlighten.zxc.repository.blog.mapper.ThumbUpMapper;
import com.bread.enlighten.zxc.repository.blog.model.ThumbUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThumbUpServiceImpl extends ServiceImpl<ThumbUpMapper, ThumbUp> implements ThumbUpService {

    @Autowired
    ThumbUpMapper thumbUpMapper;

    @Override
    public Long save(ThumbUpDTO thumbUpVo) {
//        if (thumbUpVo == null) {
//            throw new ReadMessageException("thumbUpVo can not be null");
//        }
//
//        ThumbUp thumbUp = ThumbUpVo.toModel(thumbUpVo);
//        ThumbUp resThumbUp = thumbUpRepository.save(thumbUp);

        return null;
    }

    @Override
    public void delete(Long id) {
//        if (id == null) {
//            throw new ReadMessageException("id can not be null");
//        }
//
//        ThumbUp thumbUp = thumbUpRepository.findByIdAndStatus(id, 0);
//        if (thumbUp == null) {
//            return;
//        }
//
//        thumbUp.setStatus(-2);
//        thumbUpRepository.save(thumbUp);
    }

    @Override
    public void deleteByDynamicId(Long dynamicId) {
//        if (dynamicId == null) {
//            throw new ReadMessageException("dynamicId can not be null");
//        }
//
//        List<ThumbUp> thumbUpList = thumbUpRepository.findByDynamicIdAndStatus(dynamicId, 0);
//        if (BlankUtil.isBlank(thumbUpList)) {
//            return;
//        }
//
//        thumbUpList
//                .forEach(thumbUp -> thumbUp.setStatus(-2));
//
//        thumbUpRepository.save(thumbUpList);
    }

    @Override
    public List<ThumbUpDTO> getByDynamicId(Long dynamicId) {
//        if (dynamicId == null) {
//            throw new ReadMessageException("dynamicId can not be null");
//        }
//
//        List<ThumbUp> thumbUpList = thumbUpRepository.findByDynamicIdAndStatus(dynamicId, 0);
//        if (BlankUtil.isBlank(thumbUpList)) {
//            return new ArrayList<>(0);
//        }
//
//        List<ThumbUpVo> thumbUpVoList = thumbUpList
//                .stream()
//                .map(ThumbUpVo::toVo)
//                .collect(Collectors.toList());
//
//        return thumbUpVoList;
        return null;
    }
}
