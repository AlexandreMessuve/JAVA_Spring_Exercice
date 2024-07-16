package com.m2ibank.dto;

public class BaseResponseDto {
    private Object message;
    private Object data;

    public BaseResponseDto(Object message) {
        this.message = message;
    }
    public BaseResponseDto(Object message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
