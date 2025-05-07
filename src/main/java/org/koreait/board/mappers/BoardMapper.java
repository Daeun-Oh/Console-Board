package org.koreait.board.mappers;

import org.apache.ibatis.annotations.Select;
import org.koreait.board.entities.Board;
import org.koreait.global.paging.SearchForm;

import java.util.List;
import java.util.Optional;

public interface BoardMapper {
    int register(Board board);
    List<Board> getList(SearchForm search);
    Optional<Board> get(int id);

    @Select("SELECT COUNT(*) FROM BOARD WHERE id=#{id}")
    int exists(long id);

    // 게시글 정보 수정
    int update(Board board);
}
