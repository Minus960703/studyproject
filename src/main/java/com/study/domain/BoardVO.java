package com.study.domain;

import java.util.Date;

public class BoardVO {
	
	private int bno;
	private String title;
	private String bCon;
	private Date bDate;
	private int viewCnt;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getbCon() {
		return bCon;
	}
	public void setbCon(String bCon) {
		this.bCon = bCon;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	

}
