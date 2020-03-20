package com.bread.zxc.auth.service;

import com.bread.zxc.common.exception.ReadMessageException;
import com.bread.zxc.auth.vo.UserVo;

/**
 * Created by Victor on 2017/6/15.
 */
public interface UserService {

    UserVo create(UserVo userVo);

    UserVo update(UserVo userVo) throws ReadMessageException;

    UserVo getOne(Long id) throws ReadMessageException;

    void delete(Long id);
}
