package com.crm.customer.service;
/**
 * 公司名称
 * <p>
 * 本源代码由《项目组》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2018. （company）all rights reserved.
 */

import com.crm.customer.mapper.ConsumerMapper;
import com.crm.customer.pojo.dto.ConsumerDTO;
import com.crm.customer.utils.exception.InsertException;
import org.springframework.stereotype.Service;

/**
 * @author maikec
 * @date 2019/1/21
 */
@Service
public class ConsumerSerImpl implements ConsumerSer<ConsumerDTO> {

    private final ConsumerMapper consumerMapper;

    public ConsumerSerImpl(ConsumerMapper consumerMapper){
        this.consumerMapper = consumerMapper;
    }
    @Override
    public int insert(ConsumerDTO consumerDTO) throws InsertException {
        return consumerMapper.insert( consumerDTO );
    }
}
