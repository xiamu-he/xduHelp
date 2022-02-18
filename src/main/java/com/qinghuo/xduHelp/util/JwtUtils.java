package com.qinghuo.xduHelp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.qinghuo.xduHelp.model.config.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author qzx
 * @create 2021-10-22 21:14
 * @function
 */

@Component
@EnableConfigurationProperties(JwtConfig.class)
public class JwtUtils {

    @Autowired
    JwtConfig jwtConfig;

    @Autowired
    private static JwtConfig jwtConfig1;

    @PostConstruct
    public void init() {
        jwtConfig1 = jwtConfig;
    }

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "qinghuo-jwt-xduHelp";

    /**
     * 生成token
     * @param userId //传入payload
     * @return 返回token
     */
    public static String getToken(int userId){
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("userId",userId);
        builder.withExpiresAt(new Date(System.currentTimeMillis() +jwtConfig1.getExpireTime()));//设置过期时间
        return builder.sign(Algorithm.HMAC256(TOKEN_SECRET)).toString();//设置加密算法返回Token
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static String verity(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return JWT.decode(token).getAudience().get(0);
        } catch (Exception ignored) {
        }
        return null;
    }


    public static Integer verityUser(String token) {
        Integer roleId =null;
        try {
            DecodedJWT verify = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
            return verify.getClaim("userId").asInt();
        }
        catch (Exception ignored) {
//            throw new UserDefinedException("token 错误");
        }
        return roleId;
    }

    public static Integer verityUser(HttpServletRequest request) {
        if (request.getHeader("token") == null) return null;
        return verityUser(request.getHeader("token"));
    }
}
