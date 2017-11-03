package com.sample.board.web.form;

import org.springframework.web.multipart.MultipartFile;

public class BoardForm {

	private String title;
	private String contents;
	private MultipartFile attachedfile;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public MultipartFile getAttachedfile() {
		return attachedfile;
	}
	public void setAttachedfile(MultipartFile attachedfile) {
		this.attachedfile = attachedfile;
	}
	
	@Override
	public String toString() {
		return "BoardForm [title=" + title + ", contents=" + contents + ", attachedfile=" + attachedfile + "]";
	}
	
	
	
}
