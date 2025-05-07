package org.koreait.board.services;


import lombok.Data;
import org.koreait.board.controllers.RequestBoard;
import org.koreait.board.entities.Board;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.member.MemberSession;
import org.koreait.member.entities.Member;
import org.koreait.global.validators.Validator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardCreateService1 {
    private final Validator<RequestBoard> validator;


    public BoardCreateService1(BoardMapper mapper, Validator<RequestBoard> validator) {
        this.validator = validator;

    }

    public void save(RequestBoard form){
        Board board = new Board();
        Member m = MemberSession.getMember();
        board.setWriterId(m.getSeq());
        board.setTitle(form.getTitle());
        board.setWriterId(form.getWriter_id());
        String Title = form.getTitle();
        try {
            if(Title == null && form.getTitle().isBlank()){
                String message  = form.getTitle();
                message ="작성 해주세요";
                System.out.println(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
















}
