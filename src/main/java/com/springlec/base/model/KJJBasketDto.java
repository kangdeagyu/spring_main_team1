package com.springlec.base.model;

public class KJJBasketDto {

	
	int pid;
	String cid;
	int bqty;
	
	public KJJBasketDto() {
		// TODO Auto-generated constructor stub
	}

	public KJJBasketDto(int pid, String cid, int bqty) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.bqty = bqty;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getBqty() {
		return bqty;
	}

	public void setBqty(int bqty) {
		this.bqty = bqty;
	}
	
	
}
