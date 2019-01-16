package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.vo.RspVo;
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RspVo<UserVo> register(@RequestBody UserVo user){

        return userService.save(user);
    }
}
