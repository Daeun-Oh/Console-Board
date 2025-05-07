package org.koreait.board.services;

import org.apache.ibatis.session.SqlSession;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.board.validators.BoardCreateValidator;
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
    public BoardReadService readService() {

        return new BoardReadService(boardMapper());
    }

    @Bean
    public BoardUpdateValidator updateValidator() {
        return new BoardUpdateValidator();
    }

    @Bean
    public BoardUpdateService updateService() {
        return new BoardUpdateService(boardMapper(), updateValidator());
    }
}