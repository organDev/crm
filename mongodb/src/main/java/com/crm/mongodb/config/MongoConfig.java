package com.crm.mongodb.config;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @author maikec
 * @date 2019/4/28
 */
@SpringBootConfiguration
public class MongoConfig {
    @Value( "${spring.data.mongodb.database}" )
    @Getter
    @Setter
    String dataBaseName;
    @Value("${spring.data.mongodb.host}")
    @Getter
    @Setter
    String host;
    @Value( "${spring.data.mongodb.port}" )
    @Getter
    @Setter
    Integer post;
    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDbFactory(  ));
    }
    public @Bean MongoDbFactory mongoDbFactory(){
        ServerAddress serverAddress = new ServerAddress(host,post);
        return new SimpleMongoDbFactory(new MongoClient(serverAddress), dataBaseName);
    }
}
