package com.crm.mongodb.runner;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.mongodb.dos.UserDO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author maikec
 * @date 2019/4/28
 */
@Component
public class MongoRunner implements CommandLineRunner {

    @Resource
    MongoTemplate mongoTemplate;
    @Override
    public void run(String... args) throws Exception {
        System.out.println( "Hi" );
        System.out.println( mongoTemplate.getDb());
        UserDO userDO = new UserDO();
        userDO.setName( "联车" );
        userDO.setAge( 4 );
        mongoTemplate.save( userDO );
    }
}
