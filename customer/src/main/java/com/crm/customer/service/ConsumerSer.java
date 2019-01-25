package com.crm.customer.service;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.customer.pojo.dto.ConsumerDTO;
import com.crm.customer.pojo.vo.ConsumerVO;
import com.crm.customer.utils.exception.InsertException;

/**
 * 客户管理
 * @author maikec
 * @date 2019/1/21
 */
public interface ConsumerSer<DTO extends ConsumerDTO> {
    /**
     * 新增用户
     * @param consumerDTO
     * @return
     */
    int insert(DTO consumerDTO) throws InsertException;

    /**
     * 登录
     * @param consumerVO
     * @return
     */
    ConsumerDTO login(ConsumerVO consumerVO);
}
