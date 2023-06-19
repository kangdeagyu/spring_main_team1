package com.springlec.base.model;

import java.sql.Date;

public class AdminExtra_Dto_kkg {

	
	//field
	
	int seq;
	Date date;
	int sale;
	int count;
	String month;
	int cgender;
	Date cbirthdate;
	
	String cid;
	String cpassword;
	String cname;
	String cphone;
	String category;
	String pid;
	String pname;
	String stock;
	String caddress;
	int pageNum;
	int maxpage;
	int custNum;
	
	Date cinsertdate;
	// coustructor
	
	
	int catogoryId;
	String categoryName;
	int orders;
	String genderName;
	
	
	
	// No, categoryNum, categoryName, qty, sale
	
	public AdminExtra_Dto_kkg() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public AdminExtra_Dto_kkg(int sale, String pname) {
		super();
		this.sale = sale;
		this.pname = pname;
	}








	public AdminExtra_Dto_kkg(String pname, int orders) {
		super();
		this.pname = pname;
		this.orders = orders;
	}

















	public AdminExtra_Dto_kkg(String genderName, int seq, int orders, int sale) {
		super();
		this.genderName = genderName;
		this.seq = seq;
		this.orders = orders;
		this.sale = sale;
	}

















	public AdminExtra_Dto_kkg(int seq, int catogoryId, String categoryName, int orders, int sale) {
		super();
		this.seq = seq;
		this.catogoryId = catogoryId;
		this.categoryName = categoryName;
		this.orders = orders;
		this.sale = sale;
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




	public AdminExtra_Dto_kkg(int pageNum, String cid, String cname, String cphone, Date cbirthdate, int cgender,
			String caddress, Date cinsertdate, int seq) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cphone = cphone;
		this.cbirthdate = cbirthdate;
		this.cgender = cgender;
		this.caddress = caddress;
		this.cinsertdate = cinsertdate;
		this.seq = seq;
		this.pageNum = pageNum;
	}

















	public AdminExtra_Dto_kkg(int maxpage, int custNum) {
		super();
		this.maxpage = maxpage;
		this.custNum = custNum;
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

















	public String getGenderName() {
		return genderName;
	}

















	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

















	public void setCount(int count) {
		this.count = count;
	}

















	public String getMonth() {
		return month;
	}

















	public Date getCinsertdate() {
		return cinsertdate;
	}

















	public void setCinsertdate(Date cinsertdate) {
		this.cinsertdate = cinsertdate;
	}

















	public void setMonth(String month) {
		this.month = month;
	}

















	public int getCgender() {
		return cgender;
	}

















	public void setCgender(int cgender) {
		this.cgender = cgender;
	}

















	public int getMaxpage() {
		return maxpage;
	}

















	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}

















	public int getCustNum() {
		return custNum;
	}

















	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}

















	public Date getCbirthdate() {
		return cbirthdate;
	}

















	public void setCbirthdate(Date cbirthdate) {
		this.cbirthdate = cbirthdate;
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

















	public String getCaddress() {
		return caddress;
	}

















	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

















	public int getPageNum() {
		return pageNum;
	}

















	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

















	public int getCatogoryId() {
		return catogoryId;
	}

















	public void setCatogoryId(int catogoryId) {
		this.catogoryId = catogoryId;
	}

















	public String getCategoryName() {
		return categoryName;
	}

















	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

















	public int getOrders() {
		return orders;
	}

















	public void setOrders(int orders) {
		this.orders = orders;
	}





	
	
	
	
	
	
	
	
	
	
	



	
}
