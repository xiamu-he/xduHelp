package com.qinghuo.xduHelp.exception.handler;



import com.qinghuo.xduHelp.exception.result.Result;
import com.qinghuo.xduHelp.exception.statusCode.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;


/**
 * @author ：liuzipan
 * @date ：Created in 2020/3/17 23:36
 * @description：统一异常处理接口
 * @modified By：
 */


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ServletExceptionHandler(Exception e , HttpServletResponse response) {
        // 设置http返回码
        response.setStatus(ExceptionUtil.getExceptionHttpStatusCode(e));
//        BaseResp baseResp = new BaseResp(ExceptionUtil.getExceptionCustomCode(e));
        Result result = Result.error(ExceptionUtil.getExceptionCustomCode(e));
        log.warn("[{}],{}",result.getStatus(), e.getMessage(), e);
        return result;
    }

}