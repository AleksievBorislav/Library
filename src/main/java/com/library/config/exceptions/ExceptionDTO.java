package com.library.config.exceptions;

import org.springframework.stereotype.Component;


public class ExceptionDTO {

    private final String msg;
    private final int status;

    public ExceptionDTO(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public int getStatus() {
        return status;
    }
}