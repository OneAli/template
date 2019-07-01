package com.hl.controller;

import com.hl.dto.ResultDto;
import com.hl.entity.User;
import com.hl.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;

    @RequestMapping("/save")
    @ResponseBody
    public ResultDto<Long> save(User user){
        userMapper.insert(user);
        return new ResultDto(ResultDto.SUCCESS, "save success", user.getId());
    }

    @RequestMapping("/username")
    @ResponseBody
    public ResultDto<User> getByUsername(String username){
        User user = userMapper.getByUsername(username);
        return new ResultDto(ResultDto.SUCCESS, "get success", user);
    }

}
