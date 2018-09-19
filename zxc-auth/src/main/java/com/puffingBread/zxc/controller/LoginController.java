package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.model.RspVo;
import com.puffingBread.zxc.model.User;
import com.puffingBread.zxc.service.UserService;
import com.puffingBread.zxc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/10.
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public RspVo<UserVo> regist(@RequestBody UserVo user){

        return userService.save(user);
    }
}
