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
public final class ResponseConstant {
    public static final Integer SUCCESS_UNKNOWN_ACCOUNT_CODE = 10400;
    public static final Integer SUCCESS_CODE = 10000;
    /**
     * 认证失败
     */
    public static final Integer ERROR_UNAUTHORIAED_CODE = 10401;
    public static final Integer ERROR_CODE = 20000;
    public static final String SUCCESS_MSG = "成功";
    public static final String ERROR_MSG = "失败";
    public static final String SUCCESS_PASSWORD_ERROE_MSG = "密码错误";
    public static final String SUCCESS_UNKNOWN_ACCOUNT_MSG = "用户不存在";
    public static final Integer ERROR_EXPIRED_CODE = 10408;
    public static final String ERROR_EXPIRED_MSG = "请求超时,请重新登录";
    public static final String ERROR_UNAUTHORIAED_MSG = "未认证";
    public static final String ERROR_UN_LOGGED_IN_MSG = "未登录";
}
