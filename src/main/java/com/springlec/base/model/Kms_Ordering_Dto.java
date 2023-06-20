package com.springlec.base.model;

import java.sql.Timestamp;

public class Kms_Ordering_Dto {

	int oid;
	String customer_cid;
	int product_pid;
	int oqty;
	int oprice;
	String opostnum;
	String oaddress1;
	String oaddress2;
	int odelivery;
	Timestamp odate;
	String omemo;
	String opaytype;
	String pfilename;
	
	String cname;
	String pname;
	
	public Kms_Ordering_Dto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Kms_Ordering_Dto(int oid, String customer_cid, int product_pid, int oqty, int oprice, String opostnum,
			String oaddress1, String oaddress2, int odelivery, Timestamp odate, String omemo, String opaytype, String cname, String pname, String pfilename) {
		super();
		this.oid = oid;
		this.customer_cid = customer_cid;
		this.product_pid = product_pid;
		this.oqty = oqty;
		this.oprice = oprice;
		this.opostnum = opostnum;
		this.oaddress1 = oaddress1;
		this.oaddress2 = oaddress2;
		this.odelivery = odelivery;
		this.odate = odate;
		this.omemo = omemo;
		this.opaytype = opaytype;
		this.cname = cname;
		this.pname = pname;
		this.pfilename = pfilename;
	}



	public String getPfilename() {
		return pfilename;
	}



	public void setPfilename(String pfilename) {
		this.pfilename = pfilename;
	}



	public String getOmemo() {
		return omemo;
	}



	public void setOmemo(String omemo) {
		this.omemo = omemo;
	}



	public String getOpaytype() {
		return opaytype;
	}



	public void setOpaytype(String opaytype) {
		this.opaytype = opaytype;
	}



	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getCustomer_cid() {
		return customer_cid;
	}

	public void setCustomer_cid(String customer_cid) {
		this.customer_cid = customer_cid;
	}

	public int getProduct_pid() {
		return product_pid;
	}

	public void setProduct_pid(int product_pid) {
		this.product_pid = product_pid;
	}

	public int getOqty() {
		return oqty;
	}

	public void setOqty(int oqty) {
		this.oqty = oqty;
	}

	public int getOprice() {
		return oprice;
	}

	public void setOprice(int oprice) {
		this.oprice = oprice;
	}

	public String getOpostnum() {
		return opostnum;
	}

	public void setOpostnum(String opostnum) {
		this.opostnum = opostnum;
	}

	public String getOaddress1() {
		return oaddress1;
	}

	public void setOaddress1(String oaddress1) {
		this.oaddress1 = oaddress1;
	}

	public String getOaddress2() {
		return oaddress2;
	}

	public void setOaddress2(String oaddress2) {
		this.oaddress2 = oaddress2;
	}

	public int getOdelivery() {
		return odelivery;
	}

	public void setOdelivery(int odelivery) {
		this.odelivery = odelivery;
	}

	public Timestamp getOdate() {
		return odate;
	}

	public void setOdate(Timestamp odate) {
		this.odate = odate;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	
}
