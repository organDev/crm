package com.crm.customer.demo.aop;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author maikec
 * @date 2019/2/19
 */
@Aspect
@Slf4j
public class DemoAop {
    @Pointcut("execution(* com.crm.customer.service..*(..))")
    public void aPointcut(){}

    @AfterReturning("aPointcut()")
    public void after(JoinPoint joinPoint){
        log.info( "after-----------{}",joinPoint.getSignature() );
    }
    @AfterThrowing("aPointcut()")
    public void throwing(JoinPoint joinPoint){
        log.error( "error-{}",joinPoint );
    }

}
