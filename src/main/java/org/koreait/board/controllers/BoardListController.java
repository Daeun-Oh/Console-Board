package org.koreait.board.controllers;

import org.koreait.board.entities.Board;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.router.Controller;
import org.koreait.global.validators.Validator;
import org.koreait.member.MemberSession;
import org.koreait.member.entities.Member;

import java.util.ArrayList;
import java.util.List;

public class BoardListController extends Controller {
    private final BoardMapper mapper;





    public BoardListController(BoardMapper mapper) {
        this.mapper = mapper;
        System.out.println("*****************게시글 목록**********************");
    }

    @Override
    public void show() {

//        StringBuffer count = new StringBuffer(100);
//        count.append("1.글작성" + member.getEmail()).
//                append("2.목록" + board.getTitle()).
//                append("3. 확인");


    }


//    public List<Board> getList() {
//        Member m = MemberSession.getMember();
//        Board board = new Board();
//        board.setId(m.getSeq());
//        board.setTitle(board.getTitle());
//        board.setContent(board.getContent());
//
//
//        int page = m.getSeq();
//
//        for (int i = 0; i < page; i++) {
//            int getList = i;
//            return getList();
//            System.out.println(getList);
//        }
//    }




}
