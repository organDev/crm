package com.crm.customer.component;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.crm.customer.utils.Res;

import javax.servlet.http.HttpServletResponse;

/**
 * 响应助手
 * @author maikec
 * @date 2019/1/28
 */
public final class ResponseHepler {
    public static void renderRes(HttpServletResponse response, Res res) {
        ServletUtil.write(response,
                JSONUtil.toJsonStr(res)
                ,ContentType.JSON.toString());
    }
}
