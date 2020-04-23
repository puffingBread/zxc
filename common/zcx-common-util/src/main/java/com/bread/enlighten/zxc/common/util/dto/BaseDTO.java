package com.bread.enlighten.zxc.common.util.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class BaseDTO<R> implements Serializable {

    private static final long serialVersionUID = 8752837320426966016L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public R convert() {
        throw new UnsupportedOperationException();
    }
}
