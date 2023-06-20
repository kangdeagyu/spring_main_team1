package com.springlec.base.model;

public class KJJpurchaseDto {

	
	int pid;
	String pfilename;
	String pname;
	String pcontent;
	String pprice;
	
	String cid;
	String cname;
	String cphone;
	String cpostnum;
	String caddress1;
	String caddress2;
	
	
	
	public KJJpurchaseDto() {
		// TODO Auto-generated constructor stub
	}


	public KJJpurchaseDto(int pid, String pfilename, String pname, String pcontent, String pprice) {
		super();
		this.pid = pid;
		this.pfilename = pfilename;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
	}


	public KJJpurchaseDto(String cid, String cname, String cphone, String cpostnum, String caddress1,
			String caddress2) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cphone = cphone;
		this.cpostnum = cpostnum;
		this.caddress1 = caddress1;
		this.caddress2 = caddress2;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
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


	public String getPprice() {
		return pprice;
	}


	public void setPprice(String pprice) {
		this.pprice = pprice;
	}


	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCphone() {
		return cphone;
	}


	public void setCphone(String cphone) {
		this.cphone = cphone;
	}


	public String getCpostnum() {
		return cpostnum;
	}


	public void setCpostnum(String cpostnum) {
		this.cpostnum = cpostnum;
	}


	public String getCaddress1() {
		return caddress1;
	}


	public void setCaddress1(String caddress1) {
		this.caddress1 = caddress1;
	}


	public String getCaddress2() {
		return caddress2;
	}


	public void setCaddress2(String caddress2) {
		this.caddress2 = caddress2;
	}

}
