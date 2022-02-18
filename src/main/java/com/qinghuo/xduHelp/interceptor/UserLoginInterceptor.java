package com.qinghuo.xduHelp.interceptor;


import com.qinghuo.xduHelp.exception.handler.UserDefinedException;
import com.qinghuo.xduHelp.exception.statusCode.GlobalCodeEnum;
import com.qinghuo.xduHelp.mapper.UserMapper;
import com.qinghuo.xduHelp.service.UserService;
import com.qinghuo.xduHelp.util.JwtUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qzx
 * @create 2021-10-25 20:14
 * @function
 */
@Component
public class UserLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String token = request.getHeader("token");
        //未登录
        if (token == null) {
            throw new UserDefinedException(GlobalCodeEnum.USER_NOT_LOGIN);
        }

        //登录失效
        Integer userId = JwtUtils.verityUser(token);
        if (userId == null) {
            throw new UserDefinedException(GlobalCodeEnum.TOKEN_IS_INVALID);
        } else {
            if (userService.selectByPrimaryKey(userId) == null) {
                throw new UserDefinedException(GlobalCodeEnum.USER_NOT_EXIST);
            }
        }
        return true;
    }
}
