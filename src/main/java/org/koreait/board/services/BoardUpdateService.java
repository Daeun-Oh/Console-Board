package org.koreait.board.services;

import org.koreait.board.controllers.CreateForm;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.validators.Validator;

public class BoardUpdateService {
    private BoardMapper mapper;
    private final Validator<CreateForm> validator;

    public BoardUpdateService(BoardMapper mapper, Validator<CreateForm> validator) {
        this.mapper = mapper;
        this.validator = validator;
    }

    public void process(CreateForm form) {
        /*// 회원정보 수정 유효성 검사
        validator.check(form);
        Member member = new Member();
        member.setEmail(MemberSession.getMember().getEmail());
        member.setName(form.getName());

        // 비밀번호 변경인 경우 BCrypt 해시 변환
        String password = form.getPassword();
        if (password != null && !password.isBlank()) {
            member.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
        }

        // 휴대전화번호는 숫자만 남기고 제거, 검색 편의
        String mobile = form.getMobile();
        if (mobile != null && !mobile.isBlank()) {
            mobile = mobile.replaceAll("\\D", "");
            member.setMobile(mobile);
        }

        mapper.update(member); // 수정처리

        // mybatis는 생성된 mapper 조회 결과를 캐싱하므로 이를 갱신 해야 함
        mapper = DBConn.getInstance().getSession().getMapper(MemberMapper.class);

        // 로그인한 회원 정보도 갱신한다.
        member = mapper.get(member.getEmail()).orElse(null);
        MemberSession.setMember(member);*/
    }
}
