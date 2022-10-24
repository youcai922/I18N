package com.cet.eem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author yucan
 * @date 2022/10/24 16:00
 */
public class Result<T> implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(Result.class);
    public static final int SUCCESS_CODE = 0;

    private Integer code;

    private String msg;

    private T data;

    public Result() {
        this.code = 0;
        this.msg = "";
    }

    public Result(String msg) {
        this.code = 0;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code) {
        this.code = code;
    }

    public Result(T data) {
        this.code = 0;
        this.data = data;
    }

    public static <K> Result<K> ok(K data) {
        return new Result(0, (String)null, data);
    }

    public static <K> Result<K> error(String msg) {
        return new Result(-1, msg, (Object)null);
    }

    public static <T> Result<T> ok(String msg, T data) {
        return new Result(0, msg, data);
    }

    public static <T> Result<T> ok() {
        return new Result(0, (String)null, (Object)null);
    }

    public static <T> Result<T> error() {
        return new Result(-1, (String)null, (Object)null);
    }

    public static <T> Result<T> overFileSize() {
        return new Result(-12, "文件大小超出范围", (Object)null);
    }

    public static <T> Result<T> illegalParameterError() {
        return new Result(-2, (String)null, (Object)null);
    }

    public static <T> Result<T> illegalParameterError(String msg) {
        return new Result(-2, msg, (Object)null);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == 0;
    }

    public void throwExceptionIfFailed() {
        if (!this.isSuccess()) {
            log.error(this.getMsg());
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{code=" + this.code + ", msg='" + this.msg + '\'' + ", data=" + this.data + '}';
    }
}