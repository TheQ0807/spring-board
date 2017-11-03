package com.sample.board.web.form;

public class CommentForm {

	private int boardNo;
	private String contents;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "CommentForm [boardNo=" + boardNo + ", contents=" + contents + "]";
	}
	
	
}
