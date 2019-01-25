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
import com.crm.customer.pojo.vo.ConsumerVO;
import com.crm.customer.utils.Res;
import com.crm.customer.utils.exception.InsertException;
import com.crm.customer.utils.shiro.BaseAuthenticateHepler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author maikec
 * @date 2019/1/21
 */
@Service
public class ConsumerSerImpl implements ConsumerSer<ConsumerDTO> {

    private final ConsumerMapper consumerMapper;

    @Resource
    private BaseAuthenticateHepler authenticateHepler;

    public ConsumerSerImpl(ConsumerMapper consumerMapper){
        this.consumerMapper = consumerMapper;
    }
    @Override
    public int insert(ConsumerDTO consumerDTO) throws InsertException {
        return consumerMapper.insert( consumerDTO );
    }

    @Override
    public ConsumerDTO login(ConsumerVO consumerVO) {
        ConsumerDTO consumerDTO = new ConsumerDTO();
        Res res = authenticateHepler.sign(consumerVO.getName(),"123" );
        consumerDTO.setCode( res.getCode() );
        consumerDTO.setData( res.getData() );
        consumerDTO.setMsg(res.getMsg());
        return consumerDTO;
    }
}
