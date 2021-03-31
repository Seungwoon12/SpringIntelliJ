package com.example.demo.service;

import com.example.demo.entity.board.Board;

import java.util.List;

public interface BoardService {
    // 글쓰기
    public void register(Board board) throws Exception;
    // 수정
    public void modify(Board board) throws Exception;
    // 삭제
    public void remove(Integer boardNo) throws Exception;
    // 목록보기
    public List<Board> lists() throws Exception;
    // 읽기
    public Board read(Integer boardNo) throws Exception;
}

// 출력 장치: 모니터, 스피커
// 출력: 네트워크, 콘솔(모니터), 파일 등등
// 자바 네트워크 프로그래밍 ??? 소켓 <-> 소켓 데이터 주고 받기 OutputStream, InputStream
// 분명 다 출력인데 ? 어떤건 네트워크로 나가고
// 어떤건 파일에 기록이 되고
// 어떤건 모니터에 출력이 되네 ?
// 매서드 명이 같은데 동작을 다르게 할 수 있네 ??????
// 네트워크 소켓에 무언가를 기록한다: write
// 파일에 무언가를 기록한다: write
// 모니터에 무언가를 쓴다: write

// 추상화란 ?내부에서 뭘 하는진 모르겠어
// 근대 write(적기)니까 뭐가 됫던 일단 거기에 적는데
// 향후 게시판에 작성한 내용들이 엑셀로 뽑거나 다른 회사로 정보를 이전한다거나 DB와의 통신을 수행해야한다.
// 여기서 다루는 엔티티의 변경이 발생하는가 ?

// 추상화 -> TDD -> DDD
// 나는 이제 좀 더 게으르게 편하게 일하고 싶어 <<<
// (옆에가 터져도 내가 만든것은 문제가 없다)