package com.crm.customer.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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
 * @date 2019/1/20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ConsumerMapperTest {

    @Autowired
    ConsumerMapper consumerMapper;

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
        log.info( "-------" );
        Assert.assertEquals( new Integer( 1 ), consumerMapper.selectByPrimaryKey( 1 ).getId());
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}