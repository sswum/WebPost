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

    private final BoardRepository boardRepository;


    public void save(RequestPost form) {
        Long seq = Objects.requireNonNullElse(form.getSeq(), 0L);
        Board board = boardRepository.findById(seq).orElseGet(Board::new);

        board.setSeq(form.getSeq());
        board.setTitle(form.getTitle());
        board.setName(form.getName());
        board.setContent(form.getContent());

        boardRepository.saveAndFlush(board);
    }
}
