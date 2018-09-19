package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.dao.ContentRepository;
import com.puffingBread.zxc.dao.DynamicRepository;
import com.puffingBread.zxc.model.Content;
import com.puffingBread.zxc.model.Dynamic;
import com.puffingBread.zxc.service.DynamicService;
import com.puffingBread.zxc.vo.DynamicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    private DynamicRepository dynamicRepository;
    @Autowired
    private ContentRepository contentRepository;


    public List<DynamicVo> getByUserId(long userId) {
        List<Dynamic> dynamicList = dynamicRepository.findByUserId(userId);
        List<DynamicVo> dynamicVoList = new ArrayList<DynamicVo>();
        for (Dynamic dynamic : dynamicList){
            long contentId = dynamic.getContentId();
            Content content = contentRepository.findById(contentId);
            DynamicVo vo = DynamicVo.toVo(dynamic, content);
            dynamicVoList.add(vo);
        }
        return dynamicVoList;
    }

    public List<DynamicVo> getByTime(long startTime, long endTime) {
        return null;
    }


}
