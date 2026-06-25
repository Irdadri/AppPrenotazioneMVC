package com.appprenotazione.dto;

public class SimpleResponse {
    String msg;

    public SimpleResponse(String msg) {
        this.msg = msg;
    }

    public SimpleResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
