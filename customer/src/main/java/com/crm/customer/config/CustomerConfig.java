package com.crm.customer.config;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.customer.utils.jwt.JWTHepler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author maikec
 * @date 2019/1/25
 */
@SpringBootConfiguration
public class CustomerConfig {
    @Bean
    public JWTHepler jwtHepler(@Value( "${jwt.secret}" ) String secret, @Value( "${jwt.iss}" ) String iss,
                                @Value( "${jwt.exp}" ) Integer exp, @Value( "${jwt.aud}" ) String aud){
        return new JWTHepler(secret, iss, exp, aud);
    }
}
