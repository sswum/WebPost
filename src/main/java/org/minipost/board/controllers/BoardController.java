package org.minipost.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.minipost.board.services.BoardSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardSaveService boardSaveService;

    @GetMapping("/write")
    public String write(@ModelAttribute RequestPost form) {

        return "board/write";
    }

    @GetMapping("/update/{seq}") //게시글 업데이트 - 목록
    public String update() {
        //리스트 구현
        return "board/update";
    }

    @PostMapping("/save") //게시글 저장
    public String save(@Valid RequestPost form, Errors errors) {

        String mode = form.getSeq() == null ? "update" : "write";
        if (errors.hasErrors()) {
            return "/board" + mode;
        }
        boardSaveService.save(form);

        return "board/update";

    }
}
