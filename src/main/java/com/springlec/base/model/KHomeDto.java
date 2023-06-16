package com.springlec.base.model;

public class KHomeDto {

	int pid;
	int bid;
	String pname;
	String pfilename;
	String pcontent;
	int pprice;
	String c_name;
	int bqty;
	
	public KHomeDto() {
		// TODO Auto-generated constructor stub
	}

	public KHomeDto(int pid, int bid, String pname, String pfilename, String pcontent, int pprice, String c_name,
			int bqty) {
		super();
		this.pid = pid;
		this.bid = bid;
		this.pname = pname;
		this.pfilename = pfilename;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.c_name = c_name;
		this.bqty = bqty;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPfilename() {
		return pfilename;
	}

	public void setPfilename(String pfilename) {
		this.pfilename = pfilename;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getBqty() {
		return bqty;
	}

	public void setBqty(int bqty) {
		this.bqty = bqty;
	}
	
	
}
