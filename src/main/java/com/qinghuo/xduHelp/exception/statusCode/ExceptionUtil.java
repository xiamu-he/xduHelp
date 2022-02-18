package com.qinghuo.xduHelp.exception.statusCode;

import com.qinghuo.xduHelp.exception.handler.UserDefinedException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.net.BindException;


public class ExceptionUtil {
    /**
     * 获得异常对应的自定义异常码
     *     NULL_POINTER_EXCEPTION           (9001,"空指针异常"),
     *     CLASS_CAST_EXCEPTION             (9002,"类型转换异常"),
     *     INDEX_OUT_OF_BOUNDS_EXCEPTION    (9003,"数组越界"),
     *     ARRAY_STORE_EXCEPTION            (9004,"数组存储异常"),
     *     OTHER_EXCEPTION                  (9999,"未定义的其他异常")
     */
    public static GlobalCodeEnum getExceptionCustomCode(Exception exception){
        // 自定义异常
        if(exception instanceof UserDefinedException)
            return ((UserDefinedException) exception).getGlobalCodeEnum();
        // 9XXX异常
        else if(exception instanceof NullPointerException)
            return GlobalCodeEnum.NULL_POINTER_EXCEPTION;

        else if(exception instanceof  ClassCastException)
            return GlobalCodeEnum.CLASS_CAST_EXCEPTION;

        else if(exception instanceof IndexOutOfBoundsException)
            return GlobalCodeEnum.INDEX_OUT_OF_BOUNDS_EXCEPTION;

        else if(exception instanceof ArrayStoreException)
            return GlobalCodeEnum.ARRAY_STORE_EXCEPTION;

        else if(exception instanceof DuplicateKeyException)
            return GlobalCodeEnum.DUPLICATE_KEY_EXCEPTION;

        else if(exception instanceof BindException)
            return GlobalCodeEnum.BIND_EXCEPTION;

        else if(exception instanceof ConversionNotSupportedException)
            return GlobalCodeEnum.CONVERSION_NOT_SUPPORT_EXCEPTION;

        else if(exception instanceof HttpMediaTypeNotAcceptableException)
            return GlobalCodeEnum.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION;

        else if(exception instanceof HttpMediaTypeNotSupportedException)
            return GlobalCodeEnum.HTTP_MEDIA_TYPE_NOT_SUPPORT_EXCEPTION;

        else if(exception instanceof HttpMessageNotReadableException)
            return GlobalCodeEnum.HTTP_MESSAGE_NOT_READABLE_EXCEPTION;

        else if(exception instanceof HttpMessageNotWritableException)
            return GlobalCodeEnum.HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION;

        else if(exception instanceof HttpRequestMethodNotSupportedException)
            return GlobalCodeEnum.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION;

        else if(exception instanceof MethodArgumentNotValidException)
            return GlobalCodeEnum.METHOD_ARGUMENT_NOT_VALID_EXCEPTION;

        else if(exception instanceof MissingServletRequestParameterException)
            return GlobalCodeEnum.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION;

        else if(exception instanceof MissingServletRequestPartException)
            return GlobalCodeEnum.MISSING_SERVLET_REQUEST_PART_EXCEPTION;

        else if(exception instanceof TypeMismatchException)
            return GlobalCodeEnum.TYPE_MISMATCH_EXCEPTION;

        else
            return GlobalCodeEnum.OTHER_EXCEPTION;
    }

    /**
     * @author: liuzipan
     * @description: 根据异常类型，获得其对应的http状态码
     * @date: 2020/8/21
     * @param exception
     * @return
     */
    public static Integer getExceptionHttpStatusCode(Exception exception){

        if (exception instanceof BindException) {
            return 400;
        }
        else if (exception instanceof ConversionNotSupportedException) {
            return 500;
        } else if (exception instanceof HttpMediaTypeNotAcceptableException) {
            return 406;
        } else if (exception instanceof HttpMediaTypeNotSupportedException) {
            return 415;
        } else if (exception instanceof HttpMessageNotReadableException) {
            return 400;
        } else if (exception instanceof HttpMessageNotWritableException) {
            return 500;
        } else if (exception instanceof HttpRequestMethodNotSupportedException) {
            return 405;
        } else if (exception instanceof MethodArgumentNotValidException) {
            return 400;
        } else if (exception instanceof MissingServletRequestParameterException) {
            return 400;
        } else if (exception instanceof MissingServletRequestPartException) {
            return 400;
        } else if (exception instanceof TypeMismatchException) {
            return 400;
        } else {
            return 500;
        }
    }


}
