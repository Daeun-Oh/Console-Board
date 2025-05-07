package org.koreait.board.controllers;

import org.koreait.global.router.Controller;
import org.koreait.global.router.Router;
import org.koreait.member.MemberSession;
import org.koreait.member.controllers.MemberLoginController;

import java.util.List;

import static org.koreait.member.MemberSession.isAdmin;

public class BoardController extends Controller {
    public BoardController() {
        setMenus(List.of("1", "2"));
    }
    @Override
    public void show() {
        // 로그인 상태가 아니라면 메인 페이지로 이동
        if (!MemberSession.isLogin()) {
            System.out.println("로그인이 필요합니다.");
            Router.change(MemberLoginController.class);
            return;
        }

        setMenus(isAdmin() ? List.of("1", "2", "3") : List.of("1", "2"));

        StringBuffer sb = new StringBuffer(5000);
        sb.append("1. 작성\n")
                .append("2. 전체 조회");
        System.out.println(sb);
    }

    @Override
    public void process(String command) {
        int menu = Integer.parseInt(command);

        switch (menu) {
            case 1:
                Router.change(BoardCreateController.class);
                break;
            case 2:
                Router.change(BoardReadController.class);
                break;
        }

    }
}
