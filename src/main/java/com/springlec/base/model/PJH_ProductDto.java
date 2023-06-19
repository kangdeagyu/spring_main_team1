package com.springlec.base.model;

import java.sql.Timestamp;

public class PJH_ProductDto {

	
	int pid;
	String pname;
	String pfilename;
	String pcontent;
	String pcontentfilename1;
	String pcontentfilename2;
	int pstock;
	int pprice;
	int pcategory;
	Timestamp pinsertdate;
	Timestamp pdeletedate;
	
	int c_num;
	String c_name;
	
	String cid;
	String cname;
	
	
	int mid;
	int product_pid;
	Timestamp mdate;
	
	
	public PJH_ProductDto() {
		// TODO Auto-generated constructor stub
	}




	public PJH_ProductDto(int pid, String pname, String pfilename, String pcontent, String pcontentfilename1,
			String pcontentfilename2, int pstock, int pprice, int pcategory, Timestamp pinsertdate,
			Timestamp pdeletedate, int c_num, String c_name, String cid, String cname, int mid, int product_pid,
			Timestamp mdate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pfilename = pfilename;
		this.pcontent = pcontent;
		this.pcontentfilename1 = pcontentfilename1;
		this.pcontentfilename2 = pcontentfilename2;
		this.pstock = pstock;
		this.pprice = pprice;
		this.pcategory = pcategory;
		this.pinsertdate = pinsertdate;
		this.pdeletedate = pdeletedate;
		this.c_num = c_num;
		this.c_name = c_name;
		this.cid = cid;
		this.cname = cname;
		this.mid = mid;
		this.product_pid = product_pid;
		this.mdate = mdate;
	}





	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
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


	public String getPcontentfilename1() {
		return pcontentfilename1;
	}


	public void setPcontentfilename1(String pcontentfilename1) {
		this.pcontentfilename1 = pcontentfilename1;
	}


	public String getPcontentfilename2() {
		return pcontentfilename2;
	}


	public void setPcontentfilename2(String pcontentfilename2) {
		this.pcontentfilename2 = pcontentfilename2;
	}


	public int getPstock() {
		return pstock;
	}


	public void setPstock(int pstock) {
		this.pstock = pstock;
	}


	public int getPprice() {
		return pprice;
	}


	public void setPprice(int pprice) {
		this.pprice = pprice;
	}


	public int getPcategory() {
		return pcategory;
	}


	public void setPcategory(int pcategory) {
		this.pcategory = pcategory;
	}


	public Timestamp getPinsertdate() {
		return pinsertdate;
	}


	public void setPinsertdate(Timestamp pinsertdate) {
		this.pinsertdate = pinsertdate;
	}


	public Timestamp getPdeletedate() {
		return pdeletedate;
	}


	public void setPdeletedate(Timestamp pdeletedate) {
		this.pdeletedate = pdeletedate;
	}
	
	public int getC_num() {
		return c_num;
	}





	public void setC_num(int c_num) {
		this.c_num = c_num;
	}





	public String getC_name() {
		return c_name;
	}





	public void setC_name(String c_name) {
		this.c_name = c_name;
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





	public int getMid() {
		return mid;
	}





	public void setMid(int mid) {
		this.mid = mid;
	}





	public int getProduct_pid() {
		return product_pid;
	}





	public void setProduct_pid(int product_pid) {
		this.product_pid = product_pid;
	}





	public Timestamp getMdate() {
		return mdate;
	}





	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
	}
	
	
	
	
	
	
}
