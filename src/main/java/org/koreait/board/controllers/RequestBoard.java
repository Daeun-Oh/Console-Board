package org.koreait.board.controllers;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestBoard {
    private String Title;
    private int Writer_id;
    private String Content;
    private LocalDateTime Modified_at;
    private LocalDateTime Created_at;

}
