package com.example.exercice01.controller;

import com.example.exercice01.dto.BaseResponseDto;
import com.example.exercice01.dto.UserLoginDto;
import com.example.exercice01.entity.User;
import com.example.exercice01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public BaseResponseDto register(@RequestBody User user) {
        if(userService.addUser(user)){
            return new BaseResponseDto("success");
        }else{
            return new BaseResponseDto("fail");
        }
    }

    @PostMapping("/login")
    public BaseResponseDto login(@RequestBody UserLoginDto userLoginDto) {
        if(userService.checkUserNameExists(userLoginDto.getEmail())){
            if(userService.verifyUser(userLoginDto.getEmail(), userLoginDto.getPassword())){
                String token = userService.generateToken(userLoginDto.getEmail(), userLoginDto.getPassword());
                HashMap<String, Object> data = new HashMap<>();
                data.put("token", token);
                return new BaseResponseDto("success", data);
            }
        }
        return new BaseResponseDto("Email or password invalid ! ");
    }
}
