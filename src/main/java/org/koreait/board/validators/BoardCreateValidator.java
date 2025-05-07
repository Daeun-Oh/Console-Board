package org.koreait.board.validators;

import org.koreait.board.controllers.CreateForm;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.validators.RequiredFieldValidator;
import org.koreait.global.validators.Validator;

public class BoardCreateValidator implements Validator<CreateForm>, RequiredFieldValidator {

    private final BoardMapper mapper;

    public BoardCreateValidator(BoardMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 게시글 데이터 유효성 검사
     * 1. 필수 항목 - 제목
     * 2. 내용은 2자 이상 체크
     */
    @Override
    public void check(CreateForm form) {
        String title = form.getTitle();
        String content = form.getContent();

        // 1. 필수항목 - 제목
        checkString(title, "제목을 입력하세요.");

        // 2. 내용 2자리 이상 체크
        checkTrue(content.length() >= 2, "내용을 2자리 이상 입력하세요.");
    }
}
