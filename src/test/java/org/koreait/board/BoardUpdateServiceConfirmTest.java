package org.koreait.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.board.services.BoardUpdateServiceConfirm;
import org.koreait.global.paging.SearchForm;
import org.koreait.global.validators.Validator;
import org.koreait.member.controllers.JoinForm;
import org.koreait.member.entities.Member;
import org.koreait.member.mappers.MemberMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BoardUpdateServiceConfirmTest {

    private MemberMapper memberMapper;
    private Validator<JoinForm> validator;
    private BoardUpdateServiceConfirm service;

    @BeforeEach
    void setUp() {
        // 실제 객체를 생성
        memberMapper = new MemberMapper() {
            @Override
            public int register(Member member) {
                return 0;
            }

            @Override
            public List<Member> getList(SearchForm search) {
                return List.of();
            }

            @Override
            public Optional<Member> get(String email) {
                return Optional.empty();
            }

            @Override
            public int exists(String email) {
                return 0;
            }

            @Override
            public int update(Member member) {
                return 0;
            }
        }; // 실제 구현이 필요
        validator = new Validator<>() {
            @Override
            public void check(JoinForm form) {

            }
        }; // 실제 구현이 필요
        service = new BoardUpdateServiceConfirm(memberMapper, validator);
    }

    @Test
    void testProcess_WithValidForm() {
        JoinForm form = new JoinForm();
        form.setEmail("test@example.com");

        assertDoesNotThrow(() -> service.process(form));
    }

    @Test
    void testProcess_WithNullForm() {
        Exception exception = assertThrows(NullPointerException.class, () -> service.process(null));
        assertEquals("JoinForm 객체가 null입니다.", exception.getMessage());
    }
}
