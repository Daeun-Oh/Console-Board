package org.koreait.board;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.board.entities.Board;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.configs.DBConn;

public class BoardMapperTest {
    private DBConn dbConn;

    @BeforeEach
    void init() {
        dbConn = DBConn.getInstance();
    }

    @Test
    void test1() { //테스트
        SqlSession session = dbConn.getSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = new Board();
        board.setTitle("제목1");
        board.setContent("내용1");
        board.setWriterId(1);
        mapper.register(board);
        System.out.println(board);
    }
}
