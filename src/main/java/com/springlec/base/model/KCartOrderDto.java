package com.springlec.base.model;

public class KCartOrderDto {

	String cid;
	int b_pid;
	int bqty;
	int pprice;
    String pfilename;
    String pname;
    String pcontent;
    
    public KCartOrderDto() {
		// TODO Auto-generated constructor stub
	}

	public KCartOrderDto(String cid, int b_pid, int bqty, int pprice, String pfilename, String pname, String pcontent) {
		super();
		this.cid = cid;
		this.b_pid = b_pid;
		this.bqty = bqty;
		this.pprice = pprice;
		this.pfilename = pfilename;
		this.pname = pname;
		this.pcontent = pcontent;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}



	public int getB_pid() {
		return b_pid;
	}

	public void setB_pid(int b_pid) {
		this.b_pid = b_pid;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getBqty() {
		return bqty;
	}

	public void setBqty(int bqty) {
		this.bqty = bqty;
	}

	public int getpprice() {
		return pprice;
	}

	public void setpprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPfilename() {
		return pfilename;
	}

	public void setPfilename(String pfilename) {
		this.pfilename = pfilename;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
    
}
