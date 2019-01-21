package com.crm.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author maikec
 */
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run( CustomerApplication.class, args );
    }

}

