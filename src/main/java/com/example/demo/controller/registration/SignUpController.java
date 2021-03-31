package com.example.demo.controller.registration;

import com.example.demo.entity.member.Member;
import com.example.demo.service.SignUpService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log
@Controller
public class SignUpController {

    @Autowired
    SignUpService service;

    @GetMapping("/signup")
    public String getSignUp (Member member) {
        log.info("getSignUp()");

        return "registration/signup";
    }

    @PostMapping("/signup")
    public String postSignUp (Model model, Member member) throws Exception {
        log.info("postSignUp()");

        // DB에 회원 정보 입력
        service.register(member);

        model.addAttribute("msg", "회원가입 성공!");
        
        return "registration/success";
    }
}
