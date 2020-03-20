package com.bread.zxc.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bread.zxc.repository.dto.RetweetDTO;
import com.bread.zxc.repository.mapper.RetweetMapper;
import com.bread.zxc.repository.model.Retweet;
import com.bread.zxc.repository.service.RetweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetweetServiceImpl extends ServiceImpl<RetweetMapper, Retweet> implements RetweetService {

    @Autowired
    RetweetMapper retweetMapper;

    @Override
    public Long save(RetweetDTO retweetVo) {
//        if (retweetVo == null) {
//            throw new ReadMessageException("retweetVo can not be null");
//        }
//
//        Retweet retweet = RetweetVo.toModel(retweetVo);
//        Retweet resRetweet = retweetRepository.save(retweet);

        return null;
    }

    @Override
    public void delete(Long id) {
//        if (id == null) {
//            throw new ReadMessageException("id can not be null");
//        }
//
//        Retweet retweet = retweetRepository.findByIdAndStatus(id, 0);
//        if (retweet == null) {
//            throw new ReadMessageException("can not found retweet");
//        }
//
//        retweet.setStatus(-2);
//        retweetRepository.save(retweet);
    }

    @Override
    public void deleteDynamicId(Long dynamicId) {
//        if (dynamicId == null) {
//            throw new ReadMessageException("dynamicId can not be null");
//        }
//
//        List<Retweet> retweetList = retweetRepository.findByDynamicIdAndStatus(dynamicId, 0);
//        if (BlankUtil.isBlank(retweetList)) {
//            return;
//        }
//
//        retweetList
//                .forEach(retweet -> retweet.setStatus(-2));
//
//        retweetRepository.save(retweetList);
    }

    @Override
    public List<RetweetDTO> getByDynamicId(Long dynamicId) {
//        if (dynamicId == null) {
//            throw new ReadMessageException("dynamicId can not be null");
//        }
//
//        List<Retweet> retweetList = retweetRepository.findByDynamicIdAndStatus(dynamicId, 0);
//        if (BlankUtil.isBlank(retweetList)) {
//            return new ArrayList<>(0);
//        }
//
//        List<RetweetVo> retweetVoList = retweetList
//                .stream()
//                .map(RetweetVo::toVo)
//                .collect(Collectors.toList());
//
//        return retweetVoList;
        return null;
    }
}
