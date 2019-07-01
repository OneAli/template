package com.hl.mapper;

import com.hl.entity.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {
    @Insert("insert into t_user(username, password, name) values (#{username}, #{password}, #{name})")
    void insert(User user);

    User select(Long id);
}
