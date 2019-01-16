package com.puffingBread.zxc.service;

import com.puffingBread.zxc.vo.RspVo;
import com.puffingBread.zxc.vo.UserVo;

/**
 * Created by Victor on 2017/6/15.
 */
public interface UserService {


    RspVo<UserVo> getOne(Long id);

    RspVo<UserVo> save(UserVo userVo);

    void delete(Long id);
}
