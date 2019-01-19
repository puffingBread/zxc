package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.model.User;
import com.puffingBread.zxc.service.UserService;
import com.puffingBread.zxc.vo.RspVo;
import com.puffingBread.zxc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value = "/user/registry", method = RequestMethod.POST)
    public RspVo<UserVo> registry(@RequestBody UserVo user) {

        return userService.save(user);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public RspVo<UserVo> getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递

        return userService.getOne(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public RspVo<Object> delete(@PathVariable Long id) {

        userService.delete(id);
        return new RspVo<>();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public RspVo<UserVo> updateUser(UserVo userVo) {

        return userService.save(userVo);
    }

}