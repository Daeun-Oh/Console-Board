package org.koreait.global.configs;

import org.koreait.board.controllers.*;
import org.koreait.board.services.BoardCreateService1;
import org.koreait.board.services.BoardDeleteService;
import org.koreait.board.services.BoardReadService;
import org.koreait.board.services.BoardUpdateServiceConfirm;
import org.koreait.global.services.ServiceContainer;
import org.koreait.main.controllers.MainController;
import org.koreait.member.controllers.*;
import org.koreait.member.services.MemberInfoService;
import org.koreait.member.services.MemberJoinService;
import org.koreait.member.services.MemberLoginService;
import org.koreait.member.services.MemberUpdateService;

public class ControllerConfig {

    /**
     * 첫 화면
     *
     * @return
     */
    public MainController mainController() {
        return new MainController();
    }
    /* 회원 관련 S */
    /**
     * 회원 메인 컨트롤러
     *
     * @return
     */
    public MemberController memberController() {
        return new MemberController();
    }

    // 회원 가입
    public MemberJoinController memberJoinController() {
        MemberJoinService service = ServiceContainer.getBean(MemberJoinService.class);

        return new MemberJoinController(service);
    }

    // 회원 로그인
    public MemberLoginController memberLoginController() {
        MemberLoginService service = ServiceContainer.getBean(MemberLoginService.class);

        return new MemberLoginController(service);
    }

    // 회원 정보
    public MemberInfoController memberInfoController() {
        return new MemberInfoController();
    }

    // 회원 정보 수정
    public MemberUpdateController memberUpdateController() {
        MemberUpdateService service = ServiceContainer.getBean(MemberUpdateService.class);

        return new MemberUpdateController(service);
    }

    // 회원 목록(관리자용)
    public MemberAdminController memberAdminController() {
        return new MemberAdminController();
    }
    /* 회원 관련 E */
    /**
     * 게시글 작성, 수정, 조회 관련 컨트롤러
     *
     * @return
     */
    public BoardController boardController() {
        return new BoardController();
    }

    public BoardCreateController boardWriteController() {
        BoardCreateService1 service = ServiceContainer.getBean(BoardCreateService1.class);
        return new BoardCreateController(service);
    }

    public BoardReadController boardReadController() {
        BoardReadService service = ServiceContainer.getBean(BoardReadService.class);
        MemberInfoService infoService = ServiceContainer.getBean(MemberInfoService.class);
        return new BoardReadController(service, infoService);
    }

    public BoardListController boardListController() {
        return new BoardListController();
    }

    public BoardUpdateController boardUpdateController() {
        BoardReadService service = ServiceContainer.getBean(BoardReadService.class);
        BoardUpdateServiceConfirm updateService = ServiceContainer.getBean(BoardUpdateServiceConfirm.class);
        return new BoardUpdateController(service, updateService);
    }

    public BoardDeleteController boardDeleteController() {
        BoardDeleteService deleteSevice = ServiceContainer.getBean(BoardDeleteService.class);
        BoardReadService readService = ServiceContainer.getBean(BoardReadService.class);
        return new BoardDeleteController(deleteSevice, readService);
    }
}
