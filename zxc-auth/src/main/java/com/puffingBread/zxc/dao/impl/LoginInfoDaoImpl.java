package com.puffingBread.zxc.dao.impl;

import com.puffingBread.zxc.config.DataSourceConfig;
import com.puffingBread.zxc.dao.LoginInfoDao;
import com.puffingBread.zxc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@Repository
public class LoginInfoDaoImpl implements LoginInfoDao {

    @Autowired
    private DataSourceConfig jdbcTemplate;

    @Override
    public List<User> getByTime(Date startTime, Date endTime) {
        List<Object> params = new ArrayList<>();
        params.add(new Timestamp(startTime.getTime()));
        params.add(new Timestamp(endTime.getTime()));
        String sql = "SELECT * FROM user " +
                "WHERE last_login_time >= ?" +
                "And last_login_time <= ?";

        return jdbcTemplate.jdbcTemplate().query(sql, params.toArray(), new BeanPropertyRowMapper<>(User.class));
    }


}
