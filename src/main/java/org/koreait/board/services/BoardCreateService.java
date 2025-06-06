package org.koreait.board.services;

import org.koreait.board.controllers.CreateForm;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.validators.Validator;

/**
 * 회원 가입 기능
 *
 */
public class BoardCreateService {
    private BoardMapper mapper;
    private final Validator<CreateForm> validator;  // 유효성 검사를 위한 Validator

    /**
     * 의존성 주입
     *
     * @param mapper
     * @param validator
     */
    public BoardCreateService(BoardMapper mapper, Validator<CreateForm> validator) {
        this.mapper = mapper;
        this.validator = validator;
    }

    /**
     * 회원 가입 처리
     *
     */
    public void process(CreateForm form) {
        /*// 회원 가입 데이터 유효성 검사
        validator.check(form);

        // 유효성 검사 통과했다면 DB 처리 S
        // 휴대전화번호는 검색의 편의상 숫자를 제외하고는 전부 제거
        String mobile = form.getMobile();
        if (mobile != null && !mobile.isBlank()) {
            mobile = mobile.replaceAll("\\D", "");
        }

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setName(form.getName());
        member.setMobile(mobile);
        member.setTerms(form.isTerms());

        // 비밀번호는 BCrypt 해시화하여 원 데이터가 저장되지 않도록 처리
        String hash = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt(12));
        member.setPassword(hash);

        mapper.register(member);

        // 유효성 검사 통과했다면 DB 처리 E

        // mybatis는 생성된 mapper 조회 결과를 캐싱하므로 이를 갱신 해야 함
        mapper = DBConn.getInstance().getSession().getMapper(MemberMapper.class);*/
    }



}
