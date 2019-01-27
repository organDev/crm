package com.crm.customer.utils.jwt;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;

/**
 * jwt门面
 * @author maikec
 * @date 2019/1/25
 */
@Slf4j
public class JWTHepler {
    private static String secret;
    private static String iss;
    private static Integer exp;
    private static String aud;

    private static final String CLAIMS = "claims";

    public JWTHepler(String secret, String iss, Integer exp,String aud){
        JWTHepler.secret = secret;
        JWTHepler.exp = exp;
        JWTHepler.iss = iss;
        JWTHepler.aud = aud;
    }

    /**
     * 下发令牌
     * @param claims
     * @return
     */
    public static String getToken(String ... claims){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(iss)
                    .withIssuedAt( DateUtil.date() )
                    .withExpiresAt( DateUtil.offsetMinute(DateUtil.date(),exp ) )
                    .withAudience( aud )
                    .withArrayClaim( CLAIMS,claims )
                    .sign(algorithm);
        } catch (JWTCreationException exception){
           throw new JWTCreationException("创建JWT TOKEN 异常",exception);
        }
    }


    /**
     * 验证token
     * @param token
     */
    public static void verifyToken(String token) throws JWTVerificationException{
        Assert.notNull( token,"token is null" );
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(iss)
                    .withAudience( aud )
                    .build();
            verifier.verify(token);
        } catch (TokenExpiredException | SignatureVerificationException ex) {
            throw ex;
        }
    }
}
