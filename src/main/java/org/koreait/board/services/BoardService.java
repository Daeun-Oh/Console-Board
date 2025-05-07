package org.koreait.board.services;

import org.apache.ibatis.session.SqlSession;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.board.validators.BoardCreateValidator;
import org.koreait.board.validators.BoardUpdateValidator;
import org.koreait.global.configs.DBConn;
import org.koreait.global.paging.SearchForm;
import org.koreait.global.services.Bean;
import org.koreait.global.services.Configuration;
import org.koreait.member.entities.Member;
import org.koreait.member.mappers.MemberMapper;

import java.util.List;
import java.util.Optional;

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
        return new BoardUpdateService(new MemberMapper() {
            @Override
            public int register(Member member) {
                return 0;
            }

            @Override
            public List<Member> getList(SearchForm search) {
                return List.of();
            }

            @Override
            public Optional<Member> get(String email) {
                return Optional.empty();
            }

            @Override
            public int exists(String email) {
                return 0;
            }

            @Override
            public int update(Member member) {
                return 0;
            }
        }, updateValidator());
    }
}
