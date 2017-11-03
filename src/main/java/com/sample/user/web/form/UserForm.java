package com.sample.user.web.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class UserForm {

	@NotEmpty(message="이름은 필수입력 값입니다.")
	@Length(min=2, message="이름은 2그자이상 입력해야 합니다.")
	private String fullname;
	
	@NotEmpty(message="아이디는 필수입력 값입니다.")
	@Length(min=6, max=20, message="아이디의 길이는 6~20자리 사이여야합니다.")
	private String id;
	
	@NotEmpty
	@Size(min=6, max=20)
	private String password;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Date birth;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Pattern(regexp="^\\d{3}-\\d{3,4}-\\d{4}$")
	private String phone;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserForm [fullname=" + fullname + ", id=" + id + ", password=" + password + ", birth=" + birth
				+ ", email=" + email + ", phhone=" + phone + "]";
	}
	
	
}
