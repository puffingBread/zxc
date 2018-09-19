package com.puffingBread.zxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kevin on 10.11.2016.
 */
@Controller
@RequestMapping(value="/", produces = "application/xhtml+xml;UTF-8")
public class IndexController {

    @RequestMapping
    public String index () {
        return "index";
    }


//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping("/hello")
//    public String hello() {
//        return "hello";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login() {
//        return "login";
//    }

}
