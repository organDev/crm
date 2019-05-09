package com.crm.themeleaf.demo;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author maikec
 * @date 2019/4/2
 */
@ControllerAdvice
@Slf4j
public final class ControllerExceptionHelper {
    @ExceptionHandler
    public ModelAndView handler500(Exception ex){
        log.error( "{}",ex );
        ModelAndView modelAndView = new ModelAndView( "500" );
        return modelAndView;
    }
}
