package com.hl.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.subject.Subject;
import com.hl.dto.ResultDto;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public ResultDto<Object> login(String username, String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            return new ResultDto<>(ResultDto.SUCCESS, "success", null);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultDto<>(ResultDto.FAIL, "fail", null);
        }
    }

    @RequestMapping("/")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/page/test")
    public String testPage(){
        return "test-page";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ResultDto<Object> logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ResultDto<>(ResultDto.SUCCESS,"success", null);
    }
}
