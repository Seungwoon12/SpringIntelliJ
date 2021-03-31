package com.example.demo.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// json을 알고 있나요 ?
//                    키   밸류   키   밸류   키          밸류
// JavaScript 할 때 {'test': 1, 'age': 1, 'major': 'electronics'}
// Java의 Collection에서 Map 혹은 HashMap, HashSet
// RestController가 하는 일은 실제 사용자가 URL을 요청했을때
// 데이터 처리를 json 형식으로 진행한다.
@RestController
public class RestTestController {

    // 사용자 URL에 대한 맵핑은 누가 하는가 ?
    // GetMapping이 수행한다.
    // 그래서 localhost:서비스포트번호/restTest
    // 위와 같은 형식으로 URL 요청을 할 수 있었다.
    @GetMapping("/restTest")
    public String getRestTest() {
        return "Hello from Spring Rest Controller";
    }
}
