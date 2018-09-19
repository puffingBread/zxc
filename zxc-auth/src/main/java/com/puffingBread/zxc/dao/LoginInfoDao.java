package com.puffingBread.zxc.dao;

import com.puffingBread.zxc.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface LoginInfoDao {

    List<User> getByTime(Date startTime, Date endTime);
}
