package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.dao.UserRepository;
import com.puffingBread.zxc.model.User;
import com.puffingBread.zxc.service.UserService;
import com.puffingBread.zxc.vo.RspVo;
import com.puffingBread.zxc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Victor on 2017/6/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public RspVo<UserVo> getOne(Long id) {
        User user = userRepository.findById(id);
        return new RspVo<>(UserVo.toVo(user));
    }


    @Override
    public RspVo<UserVo> save(UserVo userVo){

        User user = userRepository.save(UserVo.toModel(userVo));
        return new RspVo<>(UserVo.toVo(user));
    }


    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
