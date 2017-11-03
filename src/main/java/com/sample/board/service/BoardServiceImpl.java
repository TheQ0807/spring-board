package com.sample.board.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.board.mappers.BoardMapper;
import com.sample.board.vo.Board;
import com.sample.board.vo.Comment;
import com.sample.user.mappers.UserMapper;
import com.sample.user.vo.User;
import com.sample.web.pagination.Pagination;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public void addNewBoard(Board board) {
		boardMapper.addBoard(board);
		
		User user = board.getWriter();
		user.setPoint(user.getPoint()+10);
		userMapper.updateUser(user);
	}
	
	@Override
	public List<Board> getBoards(Pagination pagination) {
		return boardMapper.getBoards(pagination);
	}
	
	@Override
	public Board getBoardDetail(int boardNo) {
		return boardMapper.getBoard(boardNo);
	}
	
	@Override
	public int getTotalRows(Pagination pagination) {
		return boardMapper.getTotalRows(pagination);
	}
	
	@Override
	public Comment addNewComment(Comment comment) {
		int seq = boardMapper.getSeq();
		comment.setNo(seq);
		comment.setCreatedate(new Date());
		boardMapper.addComment(comment);
		return comment;
	}
	
	@Override
	public List<Comment> getComments(int boardNo) {
		return boardMapper.getCommentsByBoardNo(boardNo);
	}
	
	@Override
	public Comment removeComment(int commentNo) {
		Comment comment = boardMapper.getComment(commentNo);
		boardMapper.deleteComment(commentNo);
		return comment;
	}
	
}
