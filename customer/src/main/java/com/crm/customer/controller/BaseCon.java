package com.crm.customer.controller;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.crm.customer.utils.Res;
import com.crm.customer.utils.ResponseConstant;

/**
 * base of controller
 * @author maikec
 * @date 2019/1/22
 */
public abstract class BaseCon<VO> {

    /**
     * 成功
     * @return
     */
    protected String success(){
        Res res = new Res();
        return JSONUtil.toJsonPrettyStr( res );
    }
    protected String success(VO data){
        Res res = new Res();
        res.setData( data );
        return toJSON(res);
    }
    protected String success(String msg){
        Res res = new Res();
        res.setMsg( msg );
        return toJSON(res);
    }

    protected Object success(String msg, VO data){
        Res res = new Res();
        res.setMsg( msg );
        res.setData( data );
        return res;
    }

    protected String error(){
        return toJSON(setErrorRes(""));
    }

    protected String error(String msg){
        return toJSON(setErrorRes(msg));
    }

    private Res setErrorRes(String msg){
        Res res = new Res();
        res.setCode( ResponseConstant.ERROR_CODE );
        res.setMsg( StrUtil.isBlank( msg )?ResponseConstant.ERROR_MSG:msg );
        return res;
    }

    private String toJSON(Res res){
        return JSONUtil.toJsonPrettyStr( res );
    }

}
