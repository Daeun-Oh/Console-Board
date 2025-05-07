package org.koreait.board.services;

import org.apache.ibatis.session.SqlSession;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.board.validators.BoardCreateValidator;
import org.koreait.board.validators.BoardIdValidator;
import org.koreait.board.validators.BoardUpdateValidator;
import org.koreait.global.configs.DBConn;
import org.koreait.global.services.Bean;
import org.koreait.global.services.Configuration;

@Configuration
public class BoardService {

    public BoardMapper boardMapper() {
        SqlSession session = DBConn.getInstance().getSession();
        return session.getMapper(BoardMapper.class);
    }

    @Bean
    public BoardCreateValidator createValidator() {
        return new BoardCreateValidator(boardMapper());
    }

    @Bean
    public BoardCreateService createService() {

        return new BoardCreateService(boardMapper(), createValidator());
    }

    @Bean
    public BoardIdValidator boardIdValidator() {
        return new BoardIdValidator();
    }

    @Bean
    public BoardReadService readService() {

        return new BoardReadService(boardMapper(), boardIdValidator());
    }

    @Bean
    public BoardUpdateValidator updateValidator() {
        return new BoardUpdateValidator();
    }

    @Bean
    public BoardUpdateServiceConfirm updateService() {
        return new BoardUpdateServiceConfirm(boardMapper(), updateValidator());
    }

    @Bean
    public BoardCreateService1 boardCreateService1() {
        return new BoardCreateService1(boardMapper(), createValidator());
    }

    @Bean
    public BoardDeleteService boardDeleteService() {
        return new BoardDeleteService(boardMapper());
    }

}