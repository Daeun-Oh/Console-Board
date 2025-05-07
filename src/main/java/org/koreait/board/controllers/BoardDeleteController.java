package org.koreait.board.controllers;

import org.koreait.board.entities.Board;
import org.koreait.board.services.BoardDeleteService;
import org.koreait.board.services.BoardReadService;
import org.koreait.global.exceptions.CommonException;
import org.koreait.global.router.Controller;
import org.koreait.global.router.Router;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BoardDeleteController extends Controller {

    private final BoardReadService readService;
    private final BoardDeleteService deleteService;

    public BoardDeleteController (BoardDeleteService deleteService, BoardReadService readService) {
        this.deleteService = deleteService;
        this.readService = readService;

        setPrompt(() -> {
            while (true) {
                try {
                    // 입력 받는다
                    Scanner sc = new Scanner(System.in);

                    // 입력 받은 문자열을 boardIdS에 저장
                    String boardIdS = inputEach("삭제할 게시글 번호", sc);

                    // 입력 받은 문자열이 모두 숫자가 아니면, 예외 처리 후 게시판 관리 페이지로 넘어감.
                    if (!boardIdS.matches("\\d+")) {
                        System.out.println("숫자를 입력해주세요.");
                        Router.change(BoardController.class);
                        return;
                    }
                    // 문자열 boardIdS를 Integer.parseInt로 int형 숫자로 변환한다.
                    int boardId = Integer.parseInt(boardIdS);

                    List<Board> boardList = readService.getAllList(); // mapper를 통해 db에서 불러온다.

                    // 검색한 게시글 찾기
                    // filter로 boardList에서 삭제할 게시글의 id와 같은 게시글을 찾고 반환한다.
                    Optional<Board> optionalBoard = boardList.stream()
                            .filter(b -> b.getId() == boardId)
                            .findFirst();

                    // 삭제한다.
                    // null이어도 오류는 안 뜬다 -> 쿼리로 넘어가서 수행되면 아무 일도 안 일어나기 때문
                    deleteService.delete(boardId);

                    break;
                } catch (CommonException e) {
                    printError(e);
                }
            }

            // 삭제 후 다시 Board
            Router.change(BoardController.class);
        });
    }

    @Override
    public void show() {

//        Scanner scanner = new Scanner(System.in);
//        if (posts.isEmpty()) {
//            System.out.println("삭제할 게시글이 없습니다.");
//            return;
//        }
//
//        System.out.println("====== 게시글 목록 ======");
//        for (int i = 0; i < posts.size(); i++) {
//            System.out.println((i + 1) + ". " + posts.get(i));
//        }
//
//        System.out.print("삭제할 게시글 번호 입력 (취소하려면 0 입력) >> ");
//        try {
//            int num = Integer.parseInt(scanner.nextLine());
//
//            if (num == 0) {
//                System.out.println("삭제를 취소했습니다.");
//                return;
//            }
//
//            boolean result = deleteService.delete(posts, num - 1);
//
//            if (result) {
//                System.out.println("게시글이 삭제되었습니다.");
//            } else {
//                System.out.println("잘못된 번호입니다.");
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("숫자를 입력해주세요.");
//
//        }
//        Router.change(BoardListController.class);
    }

    public void delete(List<String> posts) {

    }
}

