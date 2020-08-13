package com.jason.demo.shardingsphere.mapper;

import com.jason.demo.shardingsphere.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: jason
 * @Date: 2020-08-13
 */
@Mapper
public interface UserMapper {
    /**
     * 保存
     */
    void save(User user);

    /**
     * 查询
     * @param id
     * @return
     */
    User get(Long id);
}
