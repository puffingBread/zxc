package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.common.utils.CollectionUtil;
import com.puffingBread.zxc.dao.RetweetRepository;
import com.puffingBread.zxc.model.Retweet;
import com.puffingBread.zxc.service.RetweetService;
import com.puffingBread.zxc.vo.RetweetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetweetServiceImpl implements RetweetService {

    @Autowired
    RetweetRepository retweetRepository;

    @Override
    public RetweetVo save(RetweetVo retweetVo) throws ReadMessageException {
        if (retweetVo == null) {
            throw new ReadMessageException("retweetVo can not be null");
        }

        Retweet retweet = RetweetVo.toModel(retweetVo);
        Retweet resRetweet = retweetRepository.save(retweet);

        return RetweetVo.toVo(resRetweet);
    }

    @Override
    public void delete(Long id) throws ReadMessageException {
        if (id == null) {
            throw new ReadMessageException("id can not be null");
        }

        Retweet retweet = retweetRepository.findByIdAndStatus(id, 0);
        if (retweet == null) {
            throw new ReadMessageException("can not found retweet");
        }

        retweet.setStatus(-2);
        retweetRepository.save(retweet);
    }

    @Override
    public void deleteDynamicId(Long dynamicId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null");
        }

        List<Retweet> retweetList = retweetRepository.findByDynamicIdAndStatus(dynamicId, 0);
        if (CollectionUtil.isEmpty(retweetList)) {
            return;
        }

        retweetList
                .forEach(retweet -> retweet.setStatus(-2));

        retweetRepository.save(retweetList);
    }

    @Override
    public List<RetweetVo> getByDynamicId(Long dynamicId) throws ReadMessageException {
        if (dynamicId == null) {
            throw new ReadMessageException("dynamicId can not be null");
        }

        List<Retweet> retweetList = retweetRepository.findByDynamicIdAndStatus(dynamicId, 0);
        if (CollectionUtil.isEmpty(retweetList)) {
            return new ArrayList<>(0);
        }

        List<RetweetVo> retweetVoList = retweetList
                .stream()
                .map(RetweetVo::toVo)
                .collect(Collectors.toList());

        return retweetVoList;
    }
}
