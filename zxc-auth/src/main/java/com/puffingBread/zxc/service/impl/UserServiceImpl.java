package com.puffingBread.zxc.service.impl;

import com.puffingBread.zxc.common.exception.ReadMessageException;
import com.puffingBread.zxc.common.utils.BlankUtil;
import com.puffingBread.zxc.dao.UserRepository;
import com.puffingBread.zxc.model.User;
import com.puffingBread.zxc.service.UserService;
import com.puffingBread.zxc.util.PasswordGenerator;
import com.puffingBread.zxc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Victor on 2017/6/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserVo create(UserVo userVo) {

        User user = new User();
        user.setId(userVo.getId());
        user.setUsername(userVo.getUsername());
        user.setPassword(PasswordGenerator.passwordGenerate(userVo.getUsername(), userVo.getPassword()));
        user.setMobilePhoneNum(userVo.getMobilePhoneNum());
        user.setCreatedTime(new Date());
        user.setCreatedBy(userVo.getCreatedBy());
        user.setUpdatedTime(new Date());
        user.setUpdatedBy(userVo.getUpdatedBy());
        user.setStatus("enable");
        User resUser = userRepository.save(user);

        return UserVo.toVo(resUser);
    }

    @Override
    public UserVo update(UserVo userVo) throws ReadMessageException {

        Long userId = userVo.getId();

        User user = userRepository.findByIdAndStatus(userId, "enable");
        if (user == null) {
            throw new ReadMessageException("userVo can not be null!");
        }

        String username = userVo.getUsername();
        if (!BlankUtil.isBlank(username)) {
            User byUsername = userRepository.findByUsername(username);
            if (byUsername != null) {
                throw new ReadMessageException("username is already exist!");
            }

            user.setUsername(username);
        }

        user.setPassword(userVo.getPassword() == null ? user.getPassword() : PasswordGenerator.passwordGenerate(user.getUsername(), userVo.getPassword()));
        user.setMobilePhoneNum(userVo.getMobilePhoneNum() == null ? user.getMobilePhoneNum() : userVo.getMobilePhoneNum());
        user.setUpdatedTime(new Date());
        user.setUpdatedBy(userVo.getUpdatedBy());
        user.setStatus("enable");
        User resUser = userRepository.save(user);

        return UserVo.toVo(resUser);
    }

    @Override
    public UserVo getOne(Long id) throws ReadMessageException {
        if (id == null) {
            throw new ReadMessageException("id can not be null!");
        }

        User user = userRepository.findByIdAndStatus(id, "enable");
        return UserVo.toVo(user);
    }



    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
