package com.Board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
