package com.crm.customer.utils.shiro;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.customer.utils.Res;

/**
 * 认证帮助类
 * @author maikec
 * @date 2019/1/25
 */
public abstract class BaseAuthenticateHepler {

    /**
     * 签名
     * @return token
     * @param username
     * @param password
     */
    public Res sign(String username, String password){
        Res res = authenticate(username, password);
        res.setData( giveToken(res.getData()));
        return res;
    }

    /**
     * 认证
     * @param username
     * @param password
     */
    protected abstract Res authenticate(String username, String password);

    /**
     * 生成令牌
     * @return token
     */
    protected abstract String giveToken(String usernamePasswordToken);
}
