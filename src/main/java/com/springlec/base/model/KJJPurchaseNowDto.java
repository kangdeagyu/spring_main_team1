package com.springlec.base.model;

public class KJJPurchaseNowDto {

	String cid;
	
	int pid;
	
	int oid;
	int product_pid;
	int oqty;
	int oprice;
	String customer_cid;
	String opustnum;
	String oaddress1;
	String oaddress2;
	String omemo;
	String opaytype;
	int odelivery;
	String odate;
	
	public KJJPurchaseNowDto() {
		// TODO Auto-generated constructor stub
	}

	public KJJPurchaseNowDto(String cid, int pid, int oid, int product_pid, int oqty, int oprice, String customer_cid,
			String opustnum, String oaddress1, String oaddress2, String omemo, String opaytype, int odelivery,
			String odate) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.oid = oid;
		this.product_pid = product_pid;
		this.oqty = oqty;
		this.oprice = oprice;
		this.customer_cid = customer_cid;
		this.opustnum = opustnum;
		this.oaddress1 = oaddress1;
		this.oaddress2 = oaddress2;
		this.omemo = omemo;
		this.opaytype = opaytype;
		this.odelivery = odelivery;
		this.odate = odate;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
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

	public String getCustomer_cid() {
		return customer_cid;
	}

	public void setCustomer_cid(String customer_cid) {
		this.customer_cid = customer_cid;
	}

	public String getOpustnum() {
		return opustnum;
	}

	public void setOpustnum(String opustnum) {
		this.opustnum = opustnum;
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

	public int getOdelivery() {
		return odelivery;
	}

	public void setOdelivery(int odelivery) {
		this.odelivery = odelivery;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}
	
	
}
