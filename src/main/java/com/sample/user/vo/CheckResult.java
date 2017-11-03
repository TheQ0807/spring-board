package com.sample.user.vo;

public class CheckResult {

	private String userid;
	private boolean isUsed;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	@Override
	public String toString() {
		return "CheckResult [userid=" + userid + ", isUsed=" + isUsed + "]";
	}
	
	
	
}
