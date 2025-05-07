package org.koreait.board.controllers;

import org.koreait.board.entities.Board;
import org.koreait.board.services.BoardReadService;
import org.koreait.board.services.BoardUpdateServiceConfirm;
import org.koreait.global.exceptions.CommonException;
import org.koreait.global.router.Controller;
import org.koreait.global.router.Router;
import org.koreait.member.MemberSession;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BoardUpdateController extends Controller {
    private final BoardReadService readService;
    private final BoardUpdateServiceConfirm updateService;
    private CreateForm form;

    public BoardUpdateController(BoardReadService readService, BoardUpdateServiceConfirm updateService) {
        this.readService = readService;
        this.updateService = updateService;
        setMenus(List.of("1", "2"));
    }

    @Override
    public void common() {
        System.out.println("*************** 게시글 수정 *******************");
    }

    @Override
    public void show() {
            form = new CreateForm();
            form.setWriterId(MemberSession.getMember().getSeq()); // 로그인한 회원 id
            System.out.println(MemberSession.getMember().getSeq());

            while (true) {
                try {
                    Scanner sc = new Scanner(System.in);

                    String boardIdS = inputEach("수정할 게시글 번호", sc);

                    if (!boardIdS.matches("\\d+")) {
                        System.out.println("숫자를 입력해주세요.");
                        Router.change(BoardController.class);
                        return;
                    }

                    int boardId = Integer.parseInt(boardIdS);
                    form.setId(boardId);

                    /* 검색한 게시글 찾기 S*/
                    List<Board> boardList = readService.getAllList();

                    System.out.println(boardList);

                    Optional<Board> optionalBoard = boardList.stream()
                            .filter(b -> b.getId() == boardId)
                            .findFirst();

                    boolean isWriterBoard = optionalBoard.stream()
                            .anyMatch(b -> b.getWriterId() == MemberSession.getMember().getSeq());

                    System.out.println(optionalBoard);

                    // 만약, 게시글 작성자가 아니면 거부한다.
                    if (!isWriterBoard) {
                        System.out.println("해당 게시글에 권한이 없습니다.");
                        return;
                    }
                    /* 검색한 게시글 찾기 E*/

                    break;
                } catch (CommonException e) {
                    printError(e);
                }
            }

            // 조회 후 다시 Board
            //Router.change(BoardController.class);


        System.out.println("변경할 번호를 선택하세요.");
        System.out.println("1. 제목, 2. 내용");
    }

    @Override
    public void process(String command) {
        int menu = Integer.parseInt(command);
        form.setWriterId(MemberSession.getMember().getSeq()); // 로그인한 회원 id

        Scanner sc = new Scanner(System.in);
        switch(menu) {
            case 1: // 제목 변경
                String title = inputEach("변경할 제목", sc);
                form.setTitle(title);
                break;
            case 2: // 내용 변경
                String content = inputEach("변경할 내용", sc);
                form.setContent(content);
                break;
        }

        updateService.process(form); // 게시글 수정

        // 수정 후 BoardController
        Router.change(BoardController.class);
    }
}
