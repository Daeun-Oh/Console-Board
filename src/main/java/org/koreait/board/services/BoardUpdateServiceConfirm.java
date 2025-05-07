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
        try {
            if (form == null) {
                throw new NullPointerException("JoinForm 객체가 null입니다.");
            }

            System.out.println("회원 정보가 성공적으로 업데이트되었습니다: " + form.getEmail());
        } catch (NullPointerException e) {
            System.out.println("오류: 회원 정보를 찾을 수 없습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("오류: 입력 데이터가 잘못되었습니다.");
        } catch (Exception e) {
            System.out.println("회원 정보 업데이트 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}

