package com.example.mini3_spring.controller;

import com.example.mini3_spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.mini3_spring.repository.UserRepository;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup")
    @ResponseBody
    public String signupPost(@ModelAttribute User user){
        // userRepository.save(user);

        User dbUser = userRepository.findByEmail(user.getEmail());
        // System.out.println(dbUser);
        // System.out.println(userRepository.findById(1L));        // 아이디가 1인 값 확인
        
        if(dbUser != null){
            System.out.println("회원가입 실패!!!");
        }else{
            System.out.println(user);   // 가져오는 값
            userRepository.save(user);
            System.out.println("회원가입 성공");
        }
        return "signup";
    }
}