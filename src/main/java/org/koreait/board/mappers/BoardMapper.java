package org.koreait.board.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.koreait.board.entities.Board;
import org.koreait.global.paging.SearchForm;

import java.util.List;
import java.util.Optional;

public interface BoardMapper {
    int register(Board board);
    List<Board> getList(SearchForm search);
    Optional<Board> get(int id);

    @Select("SELECT id, title, content, writer_id, created_at, modified_at FROM BOARD")
    @Results({
            @Result(property = "writerId", column = "writer_id"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "modifiedAt", column = "modified_at")
    })
    List<Board> getAllBoards();

    @Select("SELECT COUNT(*) FROM BOARD WHERE id=#{id}")
    int exists(long id);

    // 게시글 정보 수정
    int update(Board board);

    @Delete("DELETE FROM BOARD WHERE id=#{id}")
    boolean deleteBoard(long id);

}
