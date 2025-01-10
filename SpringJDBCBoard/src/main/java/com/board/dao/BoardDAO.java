package com.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.board.domain.Board;

@Repository
public class BoardDAO {

	// jdbc template
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static String insert = "INSERT INTO jdbcBoard(board_no, title, content, writer) "
			+ "VALUES(jdbcBoard_seq.NEXTVAL, ?, ?, ?)";
	public static String list = "SELECT board_no, title, content, writer, reg_date "
			+ "FROM jdbcBoard WHERE board_no > 0 ORDER BY board_no DESC, reg_date DESC";
	public static String selectOne = "SELECT board_no, title, content, writer, reg_date FROM jdbcBoard WHERE board_no = ?";
	public static String delete = "delete from jdbcBoard where board_no = ?";
	public static String modify = "UPDATE jdbcBoard SET title =?, content =? WHERE board_no= ?";

	// Insert 처리 메서드
	public void create(Board board) throws Exception {
		jdbcTemplate.update(insert, board.getTitle(), board.getContent(), board.getWriter());
	}

	// 목록 조회 메서드
	public List<Board> list() throws Exception {
		return jdbcTemplate.query(list, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("reg_date"));
				return board;
			}
		});
	}

	// 단일 게시물 조회 메서드
	public Board read(int boardNo) throws Exception {
		String sql = "SELECT board_no, title, content, writer, reg_date FROM jdbcBoard WHERE board_no = ?";
		List<Board> result = jdbcTemplate.query(list, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("reg_date"));
				return board;
			}
		});
		return result.isEmpty() ? null : result.get(0);
	}

	public boolean remove(Board board) throws Exception {
		int count = jdbcTemplate.update(delete, board.getBoardNo());

		return count == 0 ? false : true;
	}

	public int modify(Board board) throws Exception {

		return jdbcTemplate.update(modify, board.getTitle(), board.getContent(), board.getBoardNo());
	
	
	}

}
