package org.minipost.board.controllers;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RequestPost {

    private Long seq;
    @NotBlank
    private String title;
    @NotBlank
    private String name;
    @NotBlank
    private String content;

    private boolean agree;
}
