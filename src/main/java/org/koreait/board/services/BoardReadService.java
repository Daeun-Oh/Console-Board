package org.koreait.board.services;

import org.koreait.board.entities.Board;
import org.koreait.board.exceptions.BoardNotFoundException;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.board.validators.BoardIdValidator;
import org.koreait.global.configs.DBConn;
import org.koreait.global.paging.SearchForm;

import java.util.List;

public class BoardReadService {

    private BoardMapper mapper;
    private final BoardIdValidator validator;


    public BoardReadService(BoardMapper mapper, BoardIdValidator validator) {
        this.mapper = mapper;
        this.validator = validator;
    }


    /**
     * id로 게시글 조회
     *
     * @param id
     * @return
     */

    public Board get(int id) {
        return mapper.get(id).orElseThrow(BoardNotFoundException::new);
    }

    /**
     * 게시글 목록 조회
     *
     * @return
     */
    public List<Board> getList(SearchForm search) {
        int page = Math.max(search.getPage(), 1);
        int limit = search.getLimit();
        limit = limit < 1 ? 10 : limit;
        int offset = (page - 1) * limit;

        search.setOffset(offset);
        search.setPage(page);
        search.setLimit(limit);
        mapper = DBConn.getInstance().getSession().getMapper(BoardMapper.class);
        return mapper.getList(search);
    }

    /**
     * 게시글 목록 모두 조회
     */
    public List<Board> getAllList() {
        mapper = DBConn.getInstance().getSession().getMapper(BoardMapper.class);
        return mapper.getAllBoards();
    }

}
