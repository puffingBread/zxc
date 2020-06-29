package com.puffingBread.zxc.util;

import com.alibaba.nacos.common.utils.Md5Utils;

import java.nio.charset.StandardCharsets;

/**
 * Created by kevin on 16-9-18.
 */
public class PasswordGenerator {

    public static String passwordGenerate(String username, String password) {
//        ReflectionSaltSource saltSource = new ReflectionSaltSource();
//        saltSource.setUserPropertyToUse("username");
//
//        AppUserDetails userDetails = new AppUserDetails();
//        userDetails.setUsername(username);
//
//        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
//        return md5PasswordEncoder.encodePassword(password, saltSource.getSalt(userDetails));

        return Md5Utils.getMD5(password, StandardCharsets.UTF_8.name());
    }

    public static void main(String[] args) {

        String username = "wangcai";
        String password = "123456";

        String encodedPassword = passwordGenerate(username, password);

        System.out.println(username + "\t" + encodedPassword);
        System.out.println("\n");


    }
}
