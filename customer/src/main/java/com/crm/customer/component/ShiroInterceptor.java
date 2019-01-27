package com.crm.customer.component;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import cn.hutool.core.util.CharsetUtil;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.crm.customer.utils.Res;
import com.crm.customer.utils.ResponseConstant;
import com.crm.customer.utils.shiro.ShiroHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * shiro Interceptor 用户是否已认证、是否有效用户
 * @author maikec
 * @date 2019/1/26
 */
@Slf4j
public class ShiroInterceptor implements HandlerInterceptor {

    @Resource
    private ShiroHelper shiroHelper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            response.setCharacterEncoding( CharsetUtil.UTF_8 );
            Assert.notNull( request.getHeader( "Authorization" ), "token is null" );
            shiroHelper.verify(request.getHeader( "Authorization" ));
        } catch (TokenExpiredException e) {
            ResponseHepler.renderRes( response,
                    fillRes(ResponseConstant.ERROR_EXPIRED_CODE, ResponseConstant.ERROR_EXPIRED_MSG) );
            return false;
        } catch (JWTDecodeException e){
           ResponseHepler.renderRes( response,
                   fillRes( ResponseConstant.ERROR_UNAUTHORIAED_CODE,ResponseConstant.ERROR_UNAUTHORIAED_MSG  ) );
            return false;
        } catch (IllegalArgumentException e){
            ResponseHepler.renderRes( response,
                    fillRes( ResponseConstant.ERROR_UNAUTHORIAED_CODE, ResponseConstant.ERROR_UN_LOGGED_IN_MSG ) );
            return false;
        }
        return true;
    }

    /**
     * 填写响应体
     * @param code
     * @param msg
     * @return
     */
    private Res fillRes(int code, String msg) {
        Res res = new Res();
        res.setCode( code );
        res.setMsg( msg );
        return res;
    }
}
