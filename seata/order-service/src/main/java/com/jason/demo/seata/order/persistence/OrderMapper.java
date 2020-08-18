package com.jason.demo.seata.order.persistence;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int insert(Order record);

}