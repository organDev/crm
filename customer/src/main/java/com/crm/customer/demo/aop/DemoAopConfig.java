package com.crm.customer.demo.aop;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author maikec
 * @date 2019/2/19
 */
@SpringBootConfiguration
@EnableAspectJAutoProxy
public class DemoAopConfig {
    @Bean
    public DemoAop demoAop(){
        return new DemoAop();
    }
}
