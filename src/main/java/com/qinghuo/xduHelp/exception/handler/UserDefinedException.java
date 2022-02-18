package com.qinghuo.xduHelp.exception.handler;


import com.qinghuo.xduHelp.exception.statusCode.GlobalCodeEnum;

/**
 * @author ：liuzipan
 * @date ：Created in 2019/11/3 10:46
 * @description：自定义异常
 * @modified By：
 */
public class UserDefinedException extends RuntimeException{
    private int code;
    private String msg;
    private GlobalCodeEnum globalCodeEnum;

    public UserDefinedException(GlobalCodeEnum globalCodeEnum){
        this(globalCodeEnum.getMsg());
        this.code = globalCodeEnum.getCode();
        this.globalCodeEnum = globalCodeEnum;
    }

    public UserDefinedException(GlobalCodeEnum globalCodeEnum, String msg) {
        this(globalCodeEnum.getMsg() + " " + msg);
        this.code = globalCodeEnum.getCode();
        this.globalCodeEnum = globalCodeEnum;
    }

    public UserDefinedException(String msg){
        super(msg);
        this.msg = msg;
    }

    public GlobalCodeEnum getGlobalCodeEnum(){
        return this.globalCodeEnum;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

    @Override
    public String toString() {
        return super.toString() + " 错误码:" + this.code + " 错误信息:" + this.msg;
    }
}
