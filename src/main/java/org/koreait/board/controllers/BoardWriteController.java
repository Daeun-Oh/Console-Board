package org.koreait.board.controllers;

import org.koreait.board.services.BoardCreateService;
import org.koreait.global.exceptions.CommonException;
import org.koreait.global.router.Controller;
import org.koreait.member.MemberSession;
import org.koreait.member.entities.Member;

import java.util.Scanner;

public class BoardWriteController extends Controller {

    private final BoardCreateService service;

    public BoardWriteController(BoardCreateService service) {
        this.service = service;

        Scanner sc = new Scanner(System.in);
        CreateForm form = new CreateForm();
        // 로그인한 회원 번호로 작성자 번호 완성

        setPrompt(() -> {
            Member member = MemberSession.getMember();
            form.setWriterId(member.getSeq());
            while (true) {
                try {
                    String subject = inputEach("1. 제목", sc);
                } catch (CommonException e) {
                    printError(e);
                }
            }
        });

    }

    @Override
    public void show() {
        System.out.println("게시글을 작성하기 위한 내용을 입력하세요(m - 메인메뉴, q - 종료) >> ");
    }

    @Override
    public void common() {
        System.out.println("***************** 게시글 작성 *********************");
    }
}
