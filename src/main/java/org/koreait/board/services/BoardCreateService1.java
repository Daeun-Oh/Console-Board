package org.koreait.board.services;


import org.koreait.board.controllers.CreateForm;
import org.koreait.board.entities.Board;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.member.MemberSession;
import org.koreait.member.entities.Member;
import org.koreait.global.validators.Validator;

public class BoardCreateService1 {
    private final Validator<CreateForm> validator;
    private final BoardMapper mapper;

    public BoardCreateService1(BoardMapper mapper, Validator<CreateForm> validator) {
        this.validator = validator;
        this.mapper = mapper;




    }

    public void save(CreateForm form){
        Board board = new Board();
        Member m = MemberSession.getMember();
        board.setWriterId(m.getSeq());
        board.setTitle(form.getTitle());
        board.setWriterId(form.getWriterId());
        String Title = form.getTitle();
        try {
            if(Title == null){
                String message  = form.getTitle();
                message ="작성 해주세요";
                System.out.println(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


















}
