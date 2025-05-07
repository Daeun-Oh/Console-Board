package org.koreait.board.services;

import lombok.Getter;
import org.koreait.board.controllers.CreateForm;
import org.koreait.board.entities.Board;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.configs.DBConn;
import org.koreait.global.validators.Validator;
import org.koreait.member.MemberSession;

@Getter
public class BoardUpdateServiceConfirm {
    private BoardMapper mapper;
    private final Validator<CreateForm> validator;

    public BoardUpdateServiceConfirm (BoardMapper mapper, Validator<CreateForm> validator) {
        this.mapper = mapper;
        this.validator = validator;
    }

    public void process(CreateForm form) {
        if (form == null) {
            System.out.println("오류: 제목을 찾을 수 없습니다.");
            throw new NullPointerException("JoinForm 객체가 null입니다.");
        }

        try {
            // 회원 정보 업데이트 로직을 추가
            System.out.println("제목이 성공적으로 업데이트되었습니다.");

            Board board = new Board();
            board.setTitle(form.getTitle());
            board.setWriterId(MemberSession.getMember().getSeq());
            board.setId(form.getId());

            System.out.println(board);

            mapper.update(board); // 수정처리

            // mybatis는 생성된 mapper 조회 결과를 캐싱하므로 이를 갱신 해야 함
            mapper = DBConn.getInstance().getSession().getMapper(BoardMapper.class);

        } catch (IllegalArgumentException e) {
            System.out.println("오류: 입력 데이터가 잘못되었습니다.");
        } catch (Exception e) {
            System.out.println("변경 내용 업데이트 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
