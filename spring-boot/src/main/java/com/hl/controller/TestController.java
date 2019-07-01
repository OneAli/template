package com.hl.controller;

import com.hl.dto.ResultDto;
import com.hl.entity.User;
import com.hl.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    UserMapper userMapper;

    @RequestMapping("/hello")
    public ResultDto<String> greet(String name){
        return new ResultDto<>(0, "success", name);
    }

    @RequestMapping("/user")
    public ResultDto<String> addUser(User user){
        userMapper.insert(user);
        User select = userMapper.select(1L);
        return new ResultDto<>(0, "success", select.getUsername());
    }
}
