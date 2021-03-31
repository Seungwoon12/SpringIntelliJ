package com.example.demo.controller.board;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log
@Controller
public class BoardTestController {

    // 글쓰기
    // localhost:7777/board_test/register
    @GetMapping("/board_test/register")
    public String getRegister() {
        log.info("getRegister()");

        return "board_test/register";
    }

    // GET 방식의 경우엔 URL에 모든 데이터 정보가 출력이 됩니다.
    // 그러므로 id, pw 정보를 GET으로 넘기게 되면 계정이 털리게 되겠죠 ?
    // POST 방식의 경우엔 URL에 데이터 전송이 노출되지 않습니다.
    // 그러므로 상대적으로 데이터 자체의 안정성이 중요한 경우엔 GET이 아닌 POST를 사용합니다.
    // 실제 데이터 처리는 POST를 사용한다고 보면 됩니다.
    // 위에서 글쓰기를 눌러서 html 페이지가 나온 이후
    // form 등을 통해서 method=post가 걸려있는 상황에서
    // submit을 구동시키면 PostMapping이 동작할 것이다.
    @PostMapping("/board_test/register")
    public String postRegister() {
        log.info("postRegister()");

        return "/board_test/success";
    }

    // 수정하기를 누르면 HTML 페이지가 보이게 만들어준다.
    // localhost:7777/board_test/modify
    @GetMapping("/board_test/modify")
    public String getModify() {
        log.info("getModify()");

        return "board_test/modify";
    }

    // 실제 수정 페이지에서 완료를 눌럿을때 동작하게 만든다.
    @PostMapping("/board_test/modify")
    public String postModify() {
        log.info("postModify()");

        return "/board_test/success";
    }

    @PostMapping("/board_test/remove")
    public String postRemove() {
        log.info("postRemove()");

        return "/board_test/success";
    }

    // localhost:7777/board_test/lists
    @GetMapping("/board_test/lists")
    public String getLists() {
        log.info("getLists()");

        return "board_test/lists";
    }

    // PathVariable은 가변적인 데이터를 다루기 위해 사용한다고 보면 되겠다.
    // localhost:7777/board_test/read/3132
    @GetMapping("/board_test/read/{boardNo}")
    public String getRead(@PathVariable("boardNo") int boardNo) {
        log.info("getRead(): " + boardNo);

        return "board_test/read";
    }

    // 실제 GET 요청이나 POST 요청을 보낼 수 있도록 만든 페이지
    @GetMapping("/board_test/home")
    public String getBoardHome() {
        log.info("getBoardHome()");

        return "board_test/home";
    }
}
