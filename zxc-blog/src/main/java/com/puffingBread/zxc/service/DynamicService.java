package com.puffingBread.zxc.service;

import com.puffingBread.zxc.model.Dynamic;
import com.puffingBread.zxc.vo.DynamicVo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
public interface DynamicService {

    List<DynamicVo> getByUserId(long userId);

    List<DynamicVo> getByTime(long startTime, long endTime);
}
