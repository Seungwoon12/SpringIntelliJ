package com.example.demo.service;

import com.example.demo.entity.board.Board;
import com.example.demo.repository.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 가장 기초적인 스프링의 잘 만들어진 Form(형태)라고 한다면
// Controller -> Service -> Repository 형태로 구성된다.
// Service 키워드는 위의 Service 역할을 한다는 것을 알려주는 키워드임
// 동시에 이를 통해서 Autowired에 자동으로 붙게 된다.
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository repository;

    @Override
    public void register(Board board) throws Exception {
        repository.create(board);
    }

    @Override
    public void modify(Board board) throws Exception {
        repository.modify(board);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        repository.remove(boardNo);
    }

    @Override
    public List<Board> lists() throws Exception {
        return repository.lists();
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return repository.read(boardNo);
    }
}
