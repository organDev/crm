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
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * base of controller
 * @author maikec
 * @date 2019/1/22
 */
public abstract class BaseCon<VO> {

    private String msg;

    /**
     * 成功
     * @return
     */
    String success(){
        Res res = new Res();
        return JSONUtil.toJsonPrettyStr( res );
    }
    String success(VO data){
        Res res = new Res();
        res.setData( data );
        return toJSON(res);
    }
    String success(String msg){
        Res res = new Res();
        res.setMsg( msg );
        return toJSON(res);
    }

    String error(){
        return toJSON(setErrorRes(""));
    }

    String error(String msg){
        return toJSON(setErrorRes(msg));
    }

    private Res setErrorRes(String msg){
        Res res = new Res();
        res.setCode( res.ERROR_CODE );
        res.setMsg( StrUtil.isBlank( msg )?res.ERROR_MSG:msg );
        return res;
    }

    private String toJSON(Res res){
        return JSONUtil.toJsonPrettyStr( res );
    }


    /**
     * 响应体
     */
    class Res implements Serializable {
        final Integer SUCCESS_CODE = 10000;
        final Integer ERROR_CODE = 20000;
        final String SUCCESS_MSG = "成功";
        final String ERROR_MSG = "失败";

        Res(){
            code = SUCCESS_CODE;
            msg = SUCCESS_MSG;
            data = "";
        }
        /**
         * 响应码
         */
        @Setter
        @Getter
        Integer code;
        /**
         * 提示消息
         */
        @Setter
        @Getter
        String msg;
        /**
         * 消息体
         */
        @Getter
        String data;

        void setData(VO data) {
            this.data = JSONUtil.toJsonStr( data );
        }
    }
}
