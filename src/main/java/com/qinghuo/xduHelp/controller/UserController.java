package com.qinghuo.xduHelp.controller;

import com.qinghuo.xduHelp.exception.result.Result;
import com.qinghuo.xduHelp.service.UserService;
import com.qinghuo.xduHelp.util.JwtUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qzx
 * @create 2022-02-17 17:54
 * @function
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("小程序登录--测试jwt拦截器")
    @ApiImplicitParam(name = "code",value = "微信用户公开Id",required = true,paramType = "path")
    @PostMapping(value = "/login/{code}")
    public Result login(@PathVariable("code")String code){
        //获取openid--获取对应用户--获取用户id

        //用户id生成token
        int userId = 1;//预设userId
        String token = JwtUtils.getToken(1);
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return Result.success("登录成功",map);
    }

    @ApiOperation("查询用户个人信息")
    @ApiImplicitParam(name = "token",value = "token",required = true,paramType = "header")
    @GetMapping(value = "/personal/info")
    public Result getPersonalInfo(HttpServletRequest request){
        //根据token拿到登录的userId
        Integer userId = JwtUtils.verityUser(request.getHeader("token"));
        return userService.getPersonalInfo(userId);
    }
}
