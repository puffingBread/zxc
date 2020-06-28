package com.puffingBread.zxc.service;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.vo.UserVo;

/**
 * Created by Victor on 2017/6/15.
 */
public interface UserService {

    UserVo create(UserVo userVo);

    UserVo update(UserVo userVo) throws ReadMessageException;

    UserVo getOne(Long id) throws ReadMessageException;

    void delete(Long id);
}
