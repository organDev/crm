package com.crm.customer.utils.shiro;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * realm
 * @author maikec
 * @date 2019/1/24
 */
@SpringBootConfiguration
@ConfigurationProperties(prefix = "shiro")
public class CustomerRealm extends JdbcRealm {
    protected String authenticationQuery;
    protected String userRolesQuery;
    protected String permissionsQuery;

    public void setAuthenticationQuery() {
        super.setAuthenticationQuery( authenticationQuery );
    }

    public void setUserRolesQuery() {
        super.setUserRolesQuery( userRolesQuery );
    }

    public void setPermissionsQuery() {
        super.setPermissionsQuery( permissionsQuery );
    }

}
