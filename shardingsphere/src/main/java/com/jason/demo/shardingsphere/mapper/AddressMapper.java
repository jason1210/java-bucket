package com.jason.demo.shardingsphere.mapper;

import com.jason.demo.shardingsphere.model.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: jason
 * @Date: 2020-08-13
 */
@Mapper
public interface AddressMapper {
    /**
     * 保存
     */
    void save(Address address);

    /**
     * 查询
     * @param id
     * @return
     */
    Address get(Long id);
}