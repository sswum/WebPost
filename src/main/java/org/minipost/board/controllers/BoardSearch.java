package org.minipost.board.controllers;

import lombok.Data;

@Data
public class BoardSearch { //페이지 시작 범위부터 최대 페이지수 설정
    private int page = 1;
    private int limit = 20;

    private String sopt;
    private String skey;

}
