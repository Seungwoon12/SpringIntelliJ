package com.example.demo.repository.board;

import com.example.demo.entity.board.Board;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Log
@Repository
public class BoardRepository {

    // 사용자가 직접 DB Query를 날리는게 아닌 프로그램 형식으로 Query를 날릴 수 있도록 도와줍니다.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws Exception {
        log.info("BoardRepository create()");
        
        String query = "insert into board(title, content, writer) values(?, ?, ?)";
        
        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
    }

    public void modify(Board board) throws Exception {
        log.info("BoardRepository modify()");

        String query = "update board set title = ?, content = ? where board_no = ?";

        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
    }

    // delete from board where board_no > 5;
    public void remove(Integer boardNo) throws Exception {
        String query = "delete from board where board_no = ?";

        jdbcTemplate.update(query, boardNo);
    }

    public List<Board> lists() throws Exception {
        log.info("Repository list()");

        // 내부에 있는 Query 내용을 모두 저장할때까지 계속 List에 데이터를 쌓는다.
        List<Board> results = jdbcTemplate.query(
                /* "select board_no, title, content, writer, reg_date from board " +
                        "where board_no > 0 order by board_no desc", */
                "select * from board " +
                        "where board_no > 0 order by board_no desc",

                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Board board = new Board();
                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setRegDate(rs.getDate("reg_date"));

                        return board;
                    }
                }
        );

        return results;
    }

    public Board read(Integer boardNo) throws Exception {
        List<Board> results = jdbcTemplate.query(
                "select board_no, title, content, writer, " +
                        "reg_date from board where board_no = ?",

                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setRegDate(rs.getDate("reg_date"));

                        return board;
                    }
                }, boardNo
        );

        return results.isEmpty() ? null : results.get(0);
    }
}
