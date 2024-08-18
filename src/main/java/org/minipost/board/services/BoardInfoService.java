package org.minipost.board.services;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.minipost.board.controllers.BoardSearch;
import org.minipost.board.controllers.RequestPost;
import org.minipost.board.entities.Board;
import org.minipost.board.entities.QBoard;
import org.minipost.board.exception.BoardNotFoundException;
import org.minipost.board.repositories.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static org.springframework.data.domain.Sort.Order.desc;


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

    public Page<Board> getList(BoardSearch search) { //목록 조회 + Paging 기능까지 구현
        int page = Math.max(search.getPage(), 1); //조회하려는 페이지가 1페이지 이상 조회되게끔
        int limit = search.getLimit(); //페이징 제한
        limit = limit < 1? 20 : limit; // 제한이 1보다 크면 20까지 아니면 리미트까지

        // ALL - 통합 검색 ( title + name + content ) title : 제목 , name : 작성자 , content: 내용 , SUBJECT_CONTENT : 제목 + 내용
        String sopt = search.getSopt();
        String skey = search.getSkey();
        sopt = StringUtils.hasText(sopt) ? sopt : "ALL"; //검색 옵션을 선택하면 해당 옵션을 : 아니면 ALL옵션으로 보여줘라

        QBoard board = QBoard.board;

        BooleanBuilder andBuilder = new BooleanBuilder();
        if (StringUtils.hasText(skey)) {
            skey = skey.trim();
            if (sopt.equals("ALL")) {
                andBuilder.and(board.name.concat(board.title.concat(board.content)).contains(skey));
            } else if (sopt.equals("TITLE")) {
                andBuilder.and(board.title.contains(skey));
            } else if (sopt.equals("CONTENT")) {
                andBuilder.and(board.content.contains(skey));
            } else if (sopt.equals("SUBJECT_CONTENT")) {
                andBuilder.and(board.title.contains(skey));
            }
        }

        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(desc("createdAt")));

        Page<Board> data = boardRepository.findAll(andBuilder, pageable);
        return data;
    }


}
