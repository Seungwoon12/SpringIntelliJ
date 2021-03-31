package com.example.demo.controller.param;

import com.example.demo.entity.member.TestMember;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@Controller
@RequestMapping("/board_param_test")
public class ParameterTestController {

    @GetMapping("/register")
    public String getRegister() {
        log.info("getRegister()");

        return "board_param_test/register";
    }

    @PostMapping("register")
    public String postRegister(String userId, String passwd) {
        log.info("postRegister()");

        log.info("userId: " + userId);
        log.info("passwd: " + passwd);

        return "/board_param_test/success";
    }

    @GetMapping("/getRegisterForm")
    public String getRegisterForm() {
        log.info("getRegisterForm()");

        return "/board_param_test/objectRegister";
    }

    // 아래와 같이 엔티티 형식으로 데이터를 받을 수 있다.
    @PostMapping("/doRegister")
    public String doRegister(TestMember testMember) {
        log.info("doRegister()");

        log.info("testMember.getUserName() = " + testMember.getUserName());
        log.info("testMember.getPassword() = " + testMember.getPassword());

        return "/board_param_test/success";
    }
}
