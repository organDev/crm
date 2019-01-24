package com.crm.customer.controller;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import cn.hutool.core.date.DateUtil;
import com.crm.customer.pojo.vo.ConsumerVO;
import com.crm.customer.service.ConsumerSer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author maikec
 * @date 2019/1/21
 */
@RestController
@RequestMapping("consumer")
@Slf4j
public class ConsumerConImpl extends BaseCon implements ConsumerCon<ConsumerVO> {
    private final ConsumerSer consumerSer;

    public ConsumerConImpl(ConsumerSer consumerSer){
        this.consumerSer = consumerSer;
    }
    @Override
    @PostMapping("/insert")
    public int insert(ConsumerVO consumerVO) {
        return consumerSer.insert( consumerVO );
    }

    @GetMapping("/test")
    public Object test(){
        log.info( "test" );
        return success();
    }

    @GetMapping("/test1")
    public Object test1(){
        log.info( "test" );
        return success("test success");
    }

    @GetMapping("/test2")
    public Object test2(){
        log.info( "test" );
        ConsumerVO consumerVO = new ConsumerVO();
        consumerVO.setName( "test" );
        consumerVO.setId( 1 );
        consumerVO.setCreateTime( DateUtil.date() );
        return success(consumerVO);
    }

    @GetMapping("/error")
    public Object test3(){
        return error();
    }

    @GetMapping("/error1")
    public Object test4(){
        return error("test error");
    }

    @PostMapping("/login")
    public Object login(@RequestBody ConsumerVO consumerVO){
        log.info( consumerVO.toString() );
        return success(  );
    }
}
