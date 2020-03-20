package com.bread.zxc.auth.controller;

import com.bread.zxc.common.controller.Code;
import com.bread.zxc.auth.service.LoginService;
import com.bread.zxc.auth.vo.OauthTokenVo;
import com.bread.zxc.auth.vo.RspVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/8/10.
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public RspVo<OauthTokenVo> login(String username, String password) {

        OauthTokenVo oauthTokenVo;
        try {
            oauthTokenVo = loginService.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return new RspVo<>(Code.ERROR.code, e.getLocalizedMessage());
        }

        return new RspVo<>(oauthTokenVo);
    }
}
