package com.springlec.base.model;

public class KAdminDto {

	String aid;
	String adeletedate;
	
	public KAdminDto() {
		// TODO Auto-generated constructor stub
	}

	public KAdminDto(String aid, String adeletedate) {
		super();
		this.aid = aid;
		this.adeletedate = adeletedate;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAdeletedate() {
		return adeletedate;
	}

	public void setAdeletedate(String adeletedate) {
		this.adeletedate = adeletedate;
	}
	
	
}
