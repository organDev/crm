package com.crm.customer.mapper;

import com.crm.customer.pojo.dos.Consumer;
import java.util.List;

public interface ConsumerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consumer record);

    Consumer selectByPrimaryKey(Integer id);

    List<Consumer> selectAll();

    int updateByPrimaryKey(Consumer record);
}