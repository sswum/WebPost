package org.minipost.board.services;

import lombok.RequiredArgsConstructor;
import org.minipost.board.controllers.RequestPost;
import org.minipost.board.entities.Board;
import org.minipost.board.repositories.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class BoardSaveService {

    private final BoardRepository boardRepository; //저장소를 사용하기 위해 final


    public void save(RequestPost form) { // 커맨드객체를 매개변수로 사용
        Long seq = Objects.requireNonNullElse(form.getSeq(), 0L); //커맨드객체의 seq를 먼저 조회
        Board board = boardRepository.findById(seq).orElseGet(Board::new); // 게시판 레포지토리에서 seq 조회 아니면 새롭게 게시판 생성

        board.setSeq(form.getSeq()); // form 들어간 seq 값 변경
        board.setTitle(form.getTitle()); // title값 변경
        board.setName(form.getName()); // ...
        board.setContent(form.getContent()); // ...

        boardRepository.saveAndFlush(board); // 게시판 레포지토리에 저장
    }
}
