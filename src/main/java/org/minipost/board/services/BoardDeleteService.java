package org.minipost.board.services;

import lombok.RequiredArgsConstructor;
import org.minipost.board.repositories.BoardRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardDeleteService {
    private final BoardRepository boardRepository;

    // 해당 기능을 쓰기 위해서 추가

    public void delete(Long seq) {
        //JPA Repository에 있는 메서드 사용
        boardRepository.deleteById(seq);
        boardRepository.flush();
    }

}
