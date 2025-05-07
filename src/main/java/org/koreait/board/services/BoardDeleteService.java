package org.koreait.board.services;

import org.koreait.board.entities.Board;
import org.koreait.board.mappers.BoardMapper;

import java.util.List;

public class BoardDeleteService {
    private BoardMapper mapper;

    public BoardDeleteService(BoardMapper mapper) {
        this.mapper = mapper;
    }
    /**
     * 게시글 삭제
     * @param id - 삭제할 게시글 id
     * @return 삭제 성공 여부
     */
    public boolean delete(int id) {
        return mapper.deleteBoard(id);
    }
}
