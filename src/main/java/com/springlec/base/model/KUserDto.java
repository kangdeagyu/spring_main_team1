package com.springlec.base.model;

public class KUserDto {

	String cid;
	String cpassword;
	String cname;
	String cphone;
	String cbirthdate ;
	String cgender;
	String cpostnum;
	String caddress1;
	String caddress2;
	String cdeletedate;
	
	public KUserDto() {
		// TODO Auto-generated constructor stub
	}

	public KUserDto(String cid, String cpassword, String cname, String cphone, String cbirthdate, String cgender,
			String cpostnum, String caddress1, String caddress2) {
		super();
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.cphone = cphone;
		this.cbirthdate = cbirthdate;
		this.cgender = cgender;
		this.cpostnum = cpostnum;
		this.caddress1 = caddress1;
		this.caddress2 = caddress2;
	}

	// userCheck 확인

	public KUserDto(String cname, String cdeletedate) {
		super();
		this.cname = cname;
		this.cdeletedate = cdeletedate;
	}
	
	

	public String getCdeletedate() {
		return cdeletedate;
	}

	public void setCdeletedate(String cdeletedate) {
		this.cdeletedate = cdeletedate;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
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

	public String getCbirthdate() {
		return cbirthdate;
	}

	public void setCbirthdate(String cbirthdate) {
		this.cbirthdate = cbirthdate;
	}

	public String getCgender() {
		return cgender;
	}

	public void setCgender(String cgender) {
		this.cgender = cgender;
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
