package org.koreait.board.controllers;

import lombok.Data;

@Data
public class CreateForm {
    private int id;
    private String title;
    private String content;
    private int writerId;
}
