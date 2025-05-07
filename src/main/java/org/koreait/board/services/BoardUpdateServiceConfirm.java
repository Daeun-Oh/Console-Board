package org.koreait.board.services;

import lombok.Getter;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.validators.Validator;
import org.koreait.member.controllers.JoinForm;
import org.koreait.member.mappers.MemberMapper;

@Getter
public class BoardUpdateServiceConfirm {
    private final BoardMapper mapper;
    private final Validator<JoinForm> validator;

    public BoardUpdateServiceConfirm (MemberMapper mapper, Validator<JoinForm> validator) {
        this.mapper = (BoardMapper) mapper;
        this.validator = validator;
    }
    public void process(JoinForm form) {
        if (form == null) {
            System.out.println("오류: 제목을 찾을 수 없습니다.");
            throw new NullPointerException("JoinForm 객체가 null입니다.");
        }

        try {
            // 회원 정보 업데이트 로직을 추가
            System.out.println("제목이 성공적으로 업데이트되었습니다: ");
        } catch (IllegalArgumentException e) {
            System.out.println("오류: 입력 데이터가 잘못되었습니다.");
        } catch (Exception e) {
            System.out.println("변경 내용 업데이트 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
