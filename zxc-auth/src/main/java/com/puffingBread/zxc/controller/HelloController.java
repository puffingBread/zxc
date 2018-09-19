package com.puffingBread.zxc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return "Hello Hello 作业写完没";
    }

    @RequestMapping("/helloR")
    public String home() {
        return "Hello Docker World."
                + "<br />Welcome to <a href='http://www.baidu.com'>www.baidu.com</a></li>";
    }
}