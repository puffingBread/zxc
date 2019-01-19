package com.puffingBread.zxc.controller;

import com.puffingBread.zxc.common.controller.Code;
import com.puffingBread.zxc.service.LoginService;
import com.puffingBread.zxc.vo.OauthTokenVo;
import com.puffingBread.zxc.vo.RspVo;
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
