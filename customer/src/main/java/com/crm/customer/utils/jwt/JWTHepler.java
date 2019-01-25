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
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

/**
 * jwt门面
 * @author maikec
 * @date 2019/1/25
 */
public class JWTHepler {
    private static String secret;
    private static String iss;
    private static Integer exp;

    public JWTHepler(String secret, String iss, Integer exp){
        JWTHepler.secret = secret;
        JWTHepler.exp = exp;
        JWTHepler.iss = iss;
    }

    /**
     * 下发令牌
     * @param claims
     * @return
     */
    public static String getToken(String ... claims){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer(iss)
                    .withIssuedAt( DateUtil.date() )
                    .withExpiresAt( DateUtil.offsetMinute(DateUtil.date(),exp ) )
                    .withArrayClaim( "claims",claims )
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
           throw new JWTCreationException("创建JWT TOKEN 异常",exception);
        }
    }


//    public
}
