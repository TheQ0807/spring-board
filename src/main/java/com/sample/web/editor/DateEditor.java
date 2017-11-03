package com.sample.web.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateEditor extends PropertyEditorSupport {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	// 폼입력 값을 변수에 담을 때 실행된다.
	public void setAsText(String text) throws IllegalArgumentException {
		
		try {
			setValue(sdf.parse(text));
		} catch (ParseException e) {
			setValue(null);
		}
	
	}
	
	// 변수에 들어있는 값을 꺼낼 때 실행된다.
	public String getAsText() {
		String text = "";
		if(getValue() != null) {
			text = sdf.format(getValue());
		}
		return text;
	}
}
