package org.minipost.board.services;

import lombok.RequiredArgsConstructor;
import org.minipost.board.controllers.RequestPost;
import org.minipost.board.entities.Board;
import org.minipost.board.exception.BoardNotFoundException;
import org.minipost.board.repositories.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BoardInfoService {

    private final BoardRepository boardRepository;

    // 저장한 게시글 목록을 가져와야 한다 ( DB -> 자바 )

    public Board get(Long seq) {
        Board board = boardRepository.findById(seq).orElseThrow(BoardNotFoundException::new);
        //2차 데이터 가공 처리
        return board; // seq 가져오기
    }

    public RequestPost getForm(Long seq) { //DB에 있는 데이터 가져오기
        Board board=get(seq); // 시퀀스 번호 조회
        RequestPost form = new ModelMapper().map(board, RequestPost.class);
        return  form;
    }

//    //목록 리스트 구현 전에 페이징 추가
//    public Page<Board> getList(BoardSearch search) {
//        int page = Math.max(search.getPage);
//    }


}
