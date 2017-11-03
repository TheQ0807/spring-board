package com.sample.user.vo;

import java.util.Date;

public class User {

	private Integer no;
	private String fullname;
	private String id;
	private String password;
	private Date birth;
	private String email;
	private String phone;
	private Date createdate;
	private Integer point;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
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
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", fullname=" + fullname + ", id=" + id + ", password=" + password + ", birth="
				+ birth + ", email=" + email + ", phone=" + phone + ", createdate=" + createdate + ", point=" + point
				+ "]";
	}
	
	
	
	
}
