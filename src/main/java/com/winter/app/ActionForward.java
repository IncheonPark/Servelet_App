package com.winter.app;

public class ActionForward {
	
	// *** true > forward 실행
	// *** false > redirect 실행
	
	private boolean flag;
	
	// forward시 jsp의 경로 또는 redirect시 url 경로
	private String path;

	
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	

}
