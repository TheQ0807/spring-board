package com.sample.board.mappers;

import java.util.List;

import com.sample.board.vo.Board;
import com.sample.board.vo.Comment;
import com.sample.web.pagination.Pagination;

public interface BoardMapper {
	
	int getSeq();

	void addBoard(Board board);
	Board getBoard(int boardNo);
	
	List<Board> getBoards(Pagination pagination);
	int getTotalRows(Pagination pagination);
	
	void addComment(Comment comment);
	List<Comment> getCommentsByBoardNo(int boardNo);
	Comment getComment(int commentNo);
	void deleteComment(int commentNo);
	
}
