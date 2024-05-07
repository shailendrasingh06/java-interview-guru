package com.interview.guru.javainterviewguru.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String msg;
    private int status;
    private LocalDateTime timeStamp;


    public ExceptionResponse(String msg, int status, LocalDateTime timeStamp) {
        this.msg = msg;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
