package com.puffingBread.zxc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Administrator on 2017/8/5.
 */
@RestController
public class AuthUserController {

    @RequestMapping("/me")
    public Principal getCurrentLoggedUser(Principal user){
        return user;
    }
}
