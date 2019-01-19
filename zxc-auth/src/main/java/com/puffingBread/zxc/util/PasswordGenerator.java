package com.puffingBread.zxc.util;

import com.puffingBread.zxc.vo.AppUserDetails;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by kevin on 16-9-18.
 */
public class PasswordGenerator {

    public static String passwordGenerate(String username, String password) {
        ReflectionSaltSource saltSource = new ReflectionSaltSource();
        saltSource.setUserPropertyToUse("username");

        AppUserDetails userDetails = new AppUserDetails();
        userDetails.setUsername(username);

        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();

        return md5PasswordEncoder.encodePassword(password, saltSource.getSalt(userDetails));
    }

    public static void main(String[] args) {

        String username = "wangcai";
        String password = "123456";

        String encodedPassword = passwordGenerate(username, password);

        System.out.println(username + "\t" + encodedPassword);
        System.out.println("\n");


    }
}
