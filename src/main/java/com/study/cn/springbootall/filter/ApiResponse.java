package com.study.cn.springbootall.filter;

import com.study.cn.springbootall.exception.BusinessException;

import java.util.HashMap;
/**
 * @author huWei
 * @date 2019/7/21 11:29
 * <p> description:
 */
public class ApiResponse extends HashMap<String, Object> {
    private static final String CODE = "code";
    private static final String DATA = "data";
    private static final String MESSAGE = "message";
    private static final String ERROR = "error";

    public ApiResponse() {
        setCode(200).setData(null).setMessage(null);
    }

    public ApiResponse(Exception e) {
        setCode(500).setData(null).setMessage(e.getLocalizedMessage());
        put(ERROR, e.toString());
    }

    public ApiResponse(BusinessException e) {
        setCode(e.getCode()).setData(null).setMessage(e.getLocalizedMessage());
        put(ERROR, e.toString());
    }

    public ApiResponse setCode(int code) {
        put(CODE, code);
        return this;
    }

    public ApiResponse setData(Object data) {
        put(DATA, data);
        return this;
    }

    public ApiResponse setMessage(String message) {
        put(MESSAGE, message);
        return this;
    }

    public static String getCODE() {
        return CODE;
    }

    public static String getDATA() {
        return DATA;
    }

    public static String getMESSAGE() {
        return MESSAGE;
    }

    public static String getERROR() {
        return ERROR;
    }
}
