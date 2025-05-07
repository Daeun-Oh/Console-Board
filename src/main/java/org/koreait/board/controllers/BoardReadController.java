package org.koreait.board.controllers;

import org.koreait.board.entities.Board;
import org.koreait.board.services.BoardReadService;
import org.koreait.global.paging.SearchForm;
import org.koreait.global.router.Controller;
import org.koreait.member.services.MemberInfoService;

import java.util.List;

public class BoardReadController extends Controller {
    private final BoardReadService readService;
    private final MemberInfoService infoService;

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
        SearchForm form = new SearchForm();
        form.setOffset(0);
        form.setLimit(10);
        //form.setSopt("email");
        form.setSkey("내용");

        SearchForm memSearchForm = new SearchForm();
        form.setOffset(0);
        form.setLimit(10);
        //form.setSopt("email");
        form.setSkey("내용");

        List<Board> boardList = readService.getList(form);
//        List<Member> memberList = infoService.getList()
//        String writerName = ;



        for (Board board : boardList) {
            StringBuffer sb = new StringBuffer(5000);
            sb.append("-----[게시물 #" + board.getId() + "]-----\n")
                    .append("작성자: " + board.getWriterId() + "\n" )
                    .append("제목: " + board.getTitle() + "\n")
                    .append("내용: " + board.getContent());
            System.out.println(sb);
        }

        System.out.println(boardList);

    }
}
