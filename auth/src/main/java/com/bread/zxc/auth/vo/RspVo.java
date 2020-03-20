package com.bread.zxc.auth.vo;

public class RspVo<T> {
    int resultCode;
    String resultMsg;
    T data;

    public RspVo() {
        this.resultCode = 0;
        this.resultMsg = "success";
    }

    public RspVo(T data) {
        this.resultCode = 0;
        this.resultMsg = "success";
        this.data = data;
    }

    public RspVo(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public RspVo(int resultCode, String resultMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RspVo{" +
                "resultCode=" + resultCode +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
