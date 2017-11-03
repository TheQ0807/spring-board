package com.sample.board.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sample.web.serializer.DateSerializer;
import com.sample.user.vo.User;

public class Comment {

	private int no;
	private String contents;
	private User writer;
	@JsonSerialize(using=DateSerializer.class)
	private Date createdate;
	private Board board;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public User getWriter() {
		return writer;
	}
	public void setWriter(User writer) {
		this.writer = writer;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	@Override
	public String toString() {
		return "Comment [no=" + no + ", contents=" + contents + ", writer=" + writer + ", createdate=" + createdate
				+ ", board=" + board + "]";
	}
	
	
}
