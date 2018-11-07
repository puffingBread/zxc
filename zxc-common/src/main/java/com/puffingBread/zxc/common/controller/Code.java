package com.puffingBread.zxc.common.controller;

public enum Code {
    WITHOUT(-2, "数据不存在"),
    ERROR(-1, "请求失败"),
    SUCCESS(0, "请求成功"),
    LOGIN(1, "登录"),
    AUTHORITY(2, "权限"),
    ACTIVE(3, "激活"),
    ADMIN(4, "管理员");

    public int    code;
    public String name;

    Code(){}

    Code(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int code() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
