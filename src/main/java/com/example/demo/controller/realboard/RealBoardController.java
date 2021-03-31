package com.example.demo.controller.realboard;

import com.example.demo.entity.board.Board;
import com.example.demo.service.BoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@Controller
@RequestMapping("/real_board")
public class RealBoardController {

    // 제어 서비스
    // Autowired의 경우엔 Spring에서 관리하는 객체가 무엇인지 판정이 가능한 경우
    // 해당 객체를 자동으로 생성하여 만들고 자동으로 연결시켜주는 작업을 한다.
    @Autowired
    BoardService service;

    // 글쓰기
    @GetMapping("/getRegister")
    public String getRegister(Board board) {
        log.info("getRegister()");

        return "real_board/register";
    }

    @PostMapping("/postRegister")
    public String postRegister(Board board, Model model) throws Exception {
        log.info("postRegister(): ");

        // DB 처리 추상화 로직
        service.register(board);

        model.addAttribute("msg", "등록 성공!");

        return "real_board/success";
    }

    // 수정하기
    @GetMapping("/getModify")
    public String getModify(int boardNo, Model model) throws Exception {
        log.info("getModify() - boardNo: " + boardNo);

        // 내용을 읽어서 모델에 적용
        // 글쓰기를 통해 글을 등록하면 Board 가 만들어지고
        // 이미 read에서는 Board를 읽고 있는 상태이므로 번호로 요청해서 수정할 페이지를 띄워주면 된다.
        model.addAttribute(service.read(boardNo));

        return "real_board/modify";
    }

    @PostMapping("/postModify")
    public String postModify(Board board, Model model) throws Exception {
        log.info("postModify()");

        // DB 변경
        service.modify(board);

        model.addAttribute("msg", "수정 성공!");

        return "real_board/success";
    }

    // 삭제
    @PostMapping("/postRemove")
    public String postRemove(int boardNo, Model model) throws Exception {
        log.info("postRemove()");

        // DB 테이블 내용 삭제
        service.remove(boardNo);

        model.addAttribute("msg", "삭제 성공!");

        return "real_board/success";
    }

    // 전체 목록보기
    @GetMapping("/getLists")
    public String getLists(Model model) throws Exception {
        log.info("getLists()");

        model.addAttribute("lists", service.lists());

        return "real_board/lists";
    }

    // 읽기
    @GetMapping("/getRead")
    public String getRead(int boardNo, Model model) throws Exception {
        log.info("getRead()");

        model.addAttribute(service.read(boardNo));

        return "real_board/read";
    }
}
