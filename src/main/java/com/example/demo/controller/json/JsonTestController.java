package com.example.demo.controller.json;

import com.example.demo.entity.member.TestMember;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
@RestController
public class JsonTestController {

    @GetMapping("/jsonTestMember")
    public TestMember jsonTestMember() {
        log.info("jsonTestMember()");

        TestMember tm = new TestMember();

        return tm;
    }

    @GetMapping("/jsonListTestMember")
    public List<TestMember> jsonListTestMember() {
        log.info("jsonListTestMember()");

        List<TestMember> lists = new ArrayList<TestMember>();

        // testMember는 지역 변수(Stack)
        // new TestMember()는 동적 할당(Heap)
        TestMember testMember = new TestMember();
        lists.add(testMember);

        TestMember testMember2 = new TestMember();
        lists.add(testMember2);

        return lists;
    }

    // 위에서 일일히 생성을 하게 만들었는데 이런 케이스로 만약 100개를 만들어야 한다면 100번을 적어야 할 것이다.
    // 조금 더 편리한 방법으로 100개를 만들어서 동작하도록 위의 코드를 아래에 변경해보자!
    // 매서드명은 jsonRefactorListTestMember()로 만든다.
    @GetMapping("/jsonRefactorListTestMember")
    public List<TestMember> jsonRefactorListTestMember() {
        log.info("jsonRefactorListTestMember()");

        List<TestMember> lists = new ArrayList<TestMember>();

        for(int i = 0; i < 100; i++) {
            // lists.add()는 Collection Lists에 내용을 저장
            // new TestMember()를 하면 무엇이 만들어지나요 ?
            // 객체(메모리에 데이터가 올라감)가 생성됨
            // 우리가 사용하는 모든 데이터는 메모리에 올라가야만 써먹을 수 있다.
            lists.add(new TestMember());
        }

        return lists;
    }

    @GetMapping("/jsonHashMapTestMember")
    public Map<String, TestMember> jsonHashMapTestMember() {
        log.info("jsonHashMapTestMember()");

        Map<String, TestMember> map = new HashMap<String, TestMember>();

        for(int i = 0; i < 3; i++) {
            map.put("key" + (i + 1), new TestMember());
        }

        return map;
    }

    @GetMapping("/jsonVoidTest")
    public void jsonVoidTest() {
        log.info("jsonVoidTest()");

        return;
    }

    // 기존에 우리가 사용하는 컨트롤러는 ? RestController
    // RestController는 데이터를 ? json으로 처리함
    // 결국 ResponseEntity<>에 들어가는 내용을 지가 알아서 처리했음
    // 그러나 만약 Controller를 사용한다면 ?
    // 간혹 json 데이터를 보낼 필요가 있어
    // ResponseEntity<> 방식으로 데이터를 보내야 할 수도 있다.
    @GetMapping("/jsonREVoidTest")
    public ResponseEntity<Void> jsonREVoidTest() {
        log.info("jsonREVoidTest()");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // 돌발 퀴즈 3
    // 위쪽에 TestMember는 RestController의 수혜를 받아 매우 편하게 json화 시켰다.
    // 이번에는 현재 컨트롤러가 Controller라 가정하고 TestMember의 정보를 json화 시켜보자!
    @GetMapping("/jsonRETestMember")
    public ResponseEntity<TestMember> jsonRETestMember() {
        log.info("jsonRETestMember()");

        TestMember tm = new TestMember();

        return new ResponseEntity<TestMember>(tm, HttpStatus.OK);
    }

    @GetMapping("/jsonREListTestMember")
    public ResponseEntity<List<TestMember>> jsonREListTestMember() {
        log.info("jsonREListTestMember()");

        List<TestMember> lists = new ArrayList<TestMember>();

        for(int i = 0; i < 5; i++) {
            lists.add(new TestMember());
        }

        return new ResponseEntity<List<TestMember>>(lists, HttpStatus.OK);
    }
}
