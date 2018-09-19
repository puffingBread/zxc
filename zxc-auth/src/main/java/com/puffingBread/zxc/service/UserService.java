package com.puffingBread.zxc.service;

import com.puffingBread.zxc.model.RspVo;
import com.puffingBread.zxc.model.User;
import com.puffingBread.zxc.vo.UserVo;

import java.util.List;

/**
 * Created by Victor on 2017/6/15.
 */
public interface UserService {


    RspVo<UserVo> getOne(Long id);

    RspVo<List<UserVo>> findAll();

    RspVo<UserVo> save(UserVo userVo);

    void delete(Long id);
}
