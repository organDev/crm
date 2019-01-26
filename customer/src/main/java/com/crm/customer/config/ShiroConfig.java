package com.crm.customer.config;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import cn.hutool.core.util.StrUtil;
import com.crm.customer.component.ShiroInterceptor;
import com.crm.customer.utils.shiro.BaseAuthenticateHepler;
import com.crm.customer.utils.shiro.CustomerRealm;
import com.crm.customer.utils.shiro.ShiroHelper;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Setter;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

/**
 * Shiro配置
 * @author maikec
 * @date 2019/1/23
 */
@SpringBootConfiguration
@ConfigurationProperties(prefix = "spring.datasource")
public class ShiroConfig implements WebMvcConfigurer {
    @Setter
    private String driverClassName;
    @Setter
    private String url;
    @Setter
    private String username;
    @Setter
    private String password;
    @Value( "${shiro.exclude-uri}" )
    private String excludeUri;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( shiroInterceptor() ).addPathPatterns( "/**" )
                .excludePathPatterns( StrUtil.splitToArray( excludeUri, ',') );
    }

    @Bean
    public HandlerInterceptor shiroInterceptor(){
        return new ShiroInterceptor();
    }

    @Bean
    public BaseAuthenticateHepler authenticateHepler(){
        return new ShiroHelper();
    }

    @Bean
    public Realm realm(DataSource dataSource,CustomerRealm realm){
        realm.setDataSource( dataSource );
        return realm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(CustomerRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm( realm );
        securityManager.setSessionManager( sessionManager() );
        return securityManager;
    }

    @Bean
    public SessionManager sessionManager(){
        return new DefaultWebSessionManager(  );
    }

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new HikariDataSource(  );
        ((HikariDataSource) dataSource).setDriverClassName( driverClassName );
        ((HikariDataSource) dataSource).setJdbcUrl( url );
        ((HikariDataSource) dataSource).setUsername( username );
        ((HikariDataSource) dataSource).setPassword( password );
        return dataSource;
    }
}
