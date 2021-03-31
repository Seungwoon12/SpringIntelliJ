package com.example.demo.controller.vuetest;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log
@Controller
public class VueTestController {

    @GetMapping("/vueHome")
    public String getVueHome() {
        log.info("getVueHome()");

        return "vue/test";
    }
}
