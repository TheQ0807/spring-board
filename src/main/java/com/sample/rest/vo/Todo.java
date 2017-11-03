package com.sample.rest.vo;

public class Todo {

	private int no;
	private String title;
	private String description;
	private String dates;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	@Override
	public String toString() {
		return "Todo [no=" + no + ", title=" + title + ", description=" + description + ", dates=" + dates + "]";
	}
	
	
}
