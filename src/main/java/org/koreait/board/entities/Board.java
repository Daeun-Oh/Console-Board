package org.koreait.board.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private int id;                     // 게시글 id
    private String title;               // 제목
    private String content;             // 내용
    private int writerId;               // 작성자 id (외래키)
    private LocalDateTime createdAt;    // 작성일시
    private LocalDateTime modifiedAt;   // 수정일시
}
