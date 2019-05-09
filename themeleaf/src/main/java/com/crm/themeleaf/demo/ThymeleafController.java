package com.crm.themeleaf.demo;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @author maikec
 * @date 2019/4/2
 */
@Controller
@RequestMapping("/demo")
public class ThymeleafController {
    private static final String demoPath = "demo";
    @GetMapping("/index")
    public ModelAndView demo(){
        ModelAndView modelAndView = new ModelAndView( demoPath );
        Demo demo = new Demo();
        demo.setId( 1000 );
        demo.setName( "maikec" );
        modelAndView.addObject(demo);
        return modelAndView;
    }
    @Data
    private class Demo{
        private Integer id;
        private String name ;
    }
}
