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
import com.crm.customer.utils.ResponseConstant;
import com.crm.customer.utils.jwt.JWTHepler;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

/**
 * shiro Helper
 * @author maikec
 * @date 2019/1/25
 */
public final class ShiroHelper extends BaseAuthenticateHepler {

    @Resource
    private SecurityManager securityManager;

    @Override
    protected Res authenticate(String username, String password) {
        SecurityUtils.setSecurityManager(securityManager );
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);

        Res<String> result = new Res<>();
        try {
            subject.login( usernamePasswordToken );
            result.setData( new Md5Hash(usernamePasswordToken.toString()).toHex() );
            result.setCode( ResponseConstant.SUCCESS_CODE );
            result.setMsg( ResponseConstant.SUCCESS_MSG );
        } catch (UnknownAccountException ex){
             result.setCode( ResponseConstant.ERROR_UNAUTHORIAED_CODE );
             result.setMsg( ResponseConstant.SUCCESS_UNKNOWN_ACCOUNT_MSG );
             result.setData( "" );
        } catch (IncorrectCredentialsException ex){
            result.setCode( ResponseConstant.ERROR_UNAUTHORIAED_CODE );
            result.setMsg(ResponseConstant.SUCCESS_PASSWORD_ERROE_MSG);
            result.setData( "" );
        }
        return result;
    }

    @Override
    protected String giveToken(String usernamePasswordToken) {
        return JWTHepler.getToken( usernamePasswordToken );
    }

    public void verify(String authorization) throws ShiroException {
        JWTHepler.verifyToken( authorization );
    }
}
