package com.springlec.base.model;

import java.sql.Date;

public class AdminExtra_Dto_kkg {

	
	//field
	
	int seq;
	Date date;
	int sale;
	int count;
	String month;
	
	
	String category;
	String pid;
	String pname;
	String stock;
	
	
	
	
	
	// coustructor
	
	
	public AdminExtra_Dto_kkg() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public AdminExtra_Dto_kkg(int seq, String category, String pid, String pname, String stock) {
		super();
		this.seq = seq;
		this.category = category;
		this.pid = pid;
		this.pname = pname;
		this.stock = stock;
	}

















	public AdminExtra_Dto_kkg(int seq, Date date, int count) {
		super();
		this.seq = seq;
		this.date = date;
		this.count = count;
	}

















	public AdminExtra_Dto_kkg(int seq, String month, int sale, int count) {
		super();
		this.seq = seq;
		this.month = month;
		this.sale = sale;
		this.count = count;
	}


	public AdminExtra_Dto_kkg(int seq, Date date, int sale, int count) {
		super();
		this.seq = seq;
		this.date = date;
		this.sale = sale;
		this.count = count;
	}

















	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

















	public String getCategory() {
		return category;
	}

















	public void setCategory(String category) {
		this.category = category;
	}

















	public String getPid() {
		return pid;
	}

















	public void setPid(String pid) {
		this.pid = pid;
	}

















	public String getPname() {
		return pname;
	}

















	public void setPname(String pname) {
		this.pname = pname;
	}

















	public String getStock() {
		return stock;
	}

















	public void setStock(String stock) {
		this.stock = stock;
	}
	
	
	
	
	
	
	
	
	
	
	
}
