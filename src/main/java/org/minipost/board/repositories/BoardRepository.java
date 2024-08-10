package org.minipost.board.repositories;

import org.minipost.board.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardRepository extends JpaRepository<Board, Long> , QuerydslPredicateExecutor<Board> {
}
