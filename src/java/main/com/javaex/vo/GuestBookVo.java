package com.javaex.vo;

public class GuestBookVo {

	private int no;
	private String name;
	private String password;
	private String content;
	private String cur_date;
	
	public GuestBookVo() {
		
	}
	public GuestBookVo(String name, String password, String content) {
		this.name = name;
		this.password = password;
		this.content = content;
	}
	public GuestBookVo(int no, String name, String password, String content, String cur_date) {
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.cur_date = cur_date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return cur_date;
	}
	public void setDate(String cur_date) {
		this.cur_date = cur_date;
	}
	public String toString() {
		return no+","+name+","+password+","+content+","+cur_date;
	}
	
}
