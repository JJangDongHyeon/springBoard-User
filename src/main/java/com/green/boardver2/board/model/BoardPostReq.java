package com.green.boardver2.board.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardPostReq {
    private String title;
    private String contents;
    private long writerId;

}
