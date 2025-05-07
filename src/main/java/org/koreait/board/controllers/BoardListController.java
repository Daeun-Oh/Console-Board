package org.koreait.board.controllers;

import org.koreait.board.entities.Board;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.router.Controller;
import org.koreait.global.validators.Validator;
import org.koreait.member.MemberSession;
import org.koreait.member.entities.Member;

import java.util.List;

public class BoardListController extends Controller {


    public BoardListController (){
        System.out.println("*****************게시글 목록**********************");

    }

    @Override
    public void show() {
        

    }



}
