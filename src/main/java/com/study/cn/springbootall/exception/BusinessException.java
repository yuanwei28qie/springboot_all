package com.study.cn.springbootall.exception;

/**
 * @author huWei
 * @date 2019/7/21 12:35
 * <p> description:
 */
public class BusinessException extends RuntimeException {
    private int code = 500;
    public BusinessException(String message) {
        super(message);
    }
    public int getCode() {
        return code;
    }

}