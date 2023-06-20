package com.springlec.base.model;

public class KJJdetailPageDto {
	
	int pid;
	String cid;
	String pname;
	String pfilename;
	String pcontentfilename1;
	String pcontentfilename2;
	String pcontent;	
	int pstock;
	int pprice;
	String pcategory;
	String insertdate;
	
	public KJJdetailPageDto() {
		// TODO Auto-generated constructor stub
	}

	

	public KJJdetailPageDto(int pid, String cid, String pname, String pfilename, String pcontentfilename1,
			String pcontentfilename2, String pcontent, int pstock, int pprice, String pcategory, String insertdate) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.pname = pname;
		this.pfilename = pfilename;
		this.pcontentfilename1 = pcontentfilename1;
		this.pcontentfilename2 = pcontentfilename2;
		this.pcontent = pcontent;
		this.pstock = pstock;
		this.pprice = pprice;
		this.pcategory = pcategory;
		this.insertdate = insertdate;
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



	public String getPcontent() {
		return pcontent;
	}



	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
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



	public String getPcategory() {
		return pcategory;
	}



	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}



	public String getInsertdate() {
		return insertdate;
	}



	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

}
