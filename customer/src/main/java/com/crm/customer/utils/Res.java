package com.crm.customer.utils;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

/**
 * @author maikec
 * @date 2019/1/25
 */

import cn.hutool.json.JSONUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 响应体
 */
public class Res<VO> implements Serializable {
    public Res(){
        code = ResponseConstant.SUCCESS_CODE;
        msg = ResponseConstant.SUCCESS_MSG;
        data = "";
    }
    /**
     * 响应码
     */
    @Setter
    @Getter
    private Integer code;
    /**
     * 提示消息
     */
    @Setter
    @Getter
    private String msg;
    /**
     * 消息体
     */
    @Getter
    private String data;

    public void setData(VO data) {
        Assert.notNull( data,"data cant null" );
        this.data = JSONUtil.toJsonStr( data );
    }
}