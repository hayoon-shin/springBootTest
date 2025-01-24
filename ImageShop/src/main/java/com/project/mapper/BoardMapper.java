package com.project.mapper;

import com.project.domain.Board;

public interface BoardMapper {
	// 게시글 등록 처리
	public void create(Board board) throws Exception;
}
