package com.puffingBread.zxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kevin on 10.11.2016.
 */
@Controller
@RequestMapping(value="/loginPage", produces = "application/xhtml+xml;UTF-8")
public class LoginPageController {

    @RequestMapping
    public String showLoginPage ( Model model) {
        model.addAttribute("redirectUri", "");
        return "login";
    }
}
