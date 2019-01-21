package com.crm.customer.service;

import cn.hutool.core.date.DateUtil;
import com.crm.customer.pojo.dto.ConsumerDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

/**
 * @author maikec
 * @date 2019/1/21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConsumerSerImplTest {

    @Autowired
    ConsumerSer consumerSer;
    ConsumerDTO consumerDTO;

    @Before
    public void init(){
        consumerDTO = new ConsumerDTO();
        consumerDTO.setId( 1000 );
        consumerDTO.setName( "maikec" );
        consumerDTO.setParentId( 10001 );
        consumerDTO.setIdCard( "GZ10001" );
        consumerDTO.setNumber( "100000" );
        consumerDTO.setStatusId( 1 );
        consumerDTO.setLevelId( 1 );
        consumerDTO.setConsumerTradeId( 1 );
        consumerDTO.setCreateTime( DateUtil.date() );
        consumerDTO.setUpdateTime( DateUtil.date() );
    }
    @Test
    public void insert() {
        Assert.assertEquals( 1,consumerSer.insert( consumerDTO ) );
    }
}