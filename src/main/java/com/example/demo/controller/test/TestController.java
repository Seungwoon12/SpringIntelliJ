package com.example.demo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    // 로그를 남기기 위한 객체(런 타임에 로깅이 가능함)
    // TestController 객체의 동작에 대한 로깅을 수행하는 객체로서 log를 만든 것이다.
    private final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public String getTest() {
        log.info("getTest() 동작중!");

        return "test";
    }

    @GetMapping("/realTestString")
    public ResponseEntity<String> realTestString() {
        log.info("realTestString()");

        return new ResponseEntity<String>("test", HttpStatus.OK);
    }
}
