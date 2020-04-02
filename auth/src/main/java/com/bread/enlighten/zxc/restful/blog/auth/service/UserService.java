package com.bread.enlighten.zxc.restful.blog.auth.service;

import com.bread.enlighten.zxc.restful.blog.auth.vo.UserVo;
import com.bread.zxc.common.exception.ReadMessageException;

/**
 * Created by Victor on 2017/6/15.
 */
public interface UserService {

    UserVo create(UserVo userVo);

    UserVo update(UserVo userVo) throws ReadMessageException;

    UserVo getOne(Long id) throws ReadMessageException;

    void delete(Long id);
}
