package org.koreait.board.controllers;

import org.koreait.board.entities.Board;
import org.koreait.board.services.BoardReadService;
import org.koreait.global.exceptions.CommonException;
import org.koreait.global.router.Controller;
import org.koreait.global.router.Router;
import org.koreait.member.services.MemberInfoService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BoardReadController extends Controller {
    private final BoardReadService readService;
    private final MemberInfoService infoService;

    public BoardReadController(BoardReadService readService, MemberInfoService infoService) {
        this.readService = readService;
        this.infoService = infoService;

        setPrompt(() -> {
            while (true) {
                try {
                    Scanner sc = new Scanner(System.in);

                    String boardIdS = inputEach("검색할 게시글 번호", sc);

                    if (!boardIdS.matches("\\d+")) {
                        System.out.println("숫자를 입력해주세요.");
                        Router.change(BoardController.class);
                        return;
                    }

                    int boardId = Integer.parseInt(boardIdS);

                    /* 검색한 게시글 찾기 S*/
                    List<Board> boardList = readService.getAllList();

                    Optional<Board> optionalBoard = boardList.stream()
                            .filter(b -> b.getId() == boardId)
                            .findFirst();

                    Board selectedBoard = optionalBoard.orElse(null);
                    /* 검색한 게시글 찾기 E*/

                    try {
                        StringBuffer sb = new StringBuffer(5000);
                        sb.append("-----[게시물 #" + selectedBoard.getId() + "]-----\n")
                                .append("작성자: " + selectedBoard.getWriterId() + "\n")
                                .append("제목: " + selectedBoard.getTitle() + "\n")
                                .append("내용: " + selectedBoard.getContent());
                        System.out.println(sb);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        System.out.println("Error: 존재하지 않는 게시글입니다.");
                    }



                    break;
                } catch (CommonException e) {
                    printError(e);
                }
            }

            // 조회 후 다시 Board
            Router.change(BoardController.class);
        });
    }

    @Override
    public void common() {
        System.out.println("***************** 게시물 *********************");
    }

    @Override
    public void show() {


        /*CreateForm form = new CreateForm();
        setPrompt(() -> {
            Scanner sc = new Scanner(System.in);
            String searchId = inputEach("게시글 번호", sc);
            // 숫자인지 확인
            if (searchId.matches("\\d+")) {
                int postId = Integer.parseInt(searchId);
            } else {

            }
            form.setWriterId(id);
        });



        System.out.println(boardList);*/

    }

    @Override
    public void process(String command) {

    }
}
