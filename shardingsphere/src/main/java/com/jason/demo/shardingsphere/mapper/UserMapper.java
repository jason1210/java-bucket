package com.jason.demo.shardingsphere.mapper;

import com.jason.demo.shardingsphere.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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
     *
     * @param id
     * @return
     */
    User get(Long id);

    @Select("select * from t_user where id > 500827793022517248")
    List<User> getList();

    @Select("select * from t_user where id = #{id} for update")
    User selectByIdForUpadate(Long id);

    @Update("update t_user set `name`= #{name} ,city_id =city_id+1 where id = #{id}")
    int updateById(@Param("id") Long id, @Param("name") String name);
}
