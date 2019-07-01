package com.hl.mapper;
import com.hl.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    void insert(User user);

    @Select("select * from t_user where username = #{username}")
    User getByUsername(String username);
}
