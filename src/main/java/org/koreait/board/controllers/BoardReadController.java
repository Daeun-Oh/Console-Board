package org.koreait.board.controllers;

import org.koreait.board.entities.Board;
import org.koreait.board.services.BoardReadService;
import org.koreait.global.paging.SearchForm;
import org.koreait.global.router.Controller;
import org.koreait.global.validators.IdValidator;
import org.koreait.member.services.MemberInfoService;

import java.util.List;
import java.util.Scanner;

public class BoardReadController extends Controller {
    private final BoardReadService readService;
    private final MemberInfoService infoService;
    private IdValidator validator;

    public BoardReadController(BoardReadService readService, MemberInfoService infoService) {
        this.readService = readService;
        this.infoService = infoService;
    }

    @Override
    public void common() {
        System.out.println("***************** 게시물 *********************");
    }

    @Override
    public void show() {


        CreateForm form = new CreateForm();
        setPrompt(() -> {
            Scanner sc = new Scanner(System.in);
            String searchId = inputEach("게시글 번호", sc);
            int id = validator.stringToId(searchId);
            form.setWriterId(id);
        });

        SearchForm sForm = new SearchForm();
        sForm.setSkey("내용");
        List<Board> boardList = readService.getList(sForm);

        for (Board board : boardList) {
            if (board.getId() == form.getWriterId()) {
                StringBuffer sb = new StringBuffer(5000);
                sb.append("-----[게시물 #" + board.getId() + "]-----\n")
                        .append("작성자: " + board.getWriterId() + "\n")
                        .append("제목: " + board.getTitle() + "\n")
                        .append("내용: " + board.getContent());
                System.out.println(sb);
            }
        }

        System.out.println(boardList);

    }
}
