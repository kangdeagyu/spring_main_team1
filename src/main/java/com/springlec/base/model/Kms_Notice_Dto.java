package com.springlec.base.model;

import java.sql.Timestamp;

public class Kms_Notice_Dto {

	int nid;
	String n_aid;
	String ntitle;
	String ncontent;
	Timestamp ninsertdate;
	Timestamp ndeletedate;
	
	public Kms_Notice_Dto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Kms_Notice_Dto(int nid, String n_aid, String ntitle, String ncontent, Timestamp ninsertdate,
			Timestamp ndeletedate) {
		super();
		this.nid = nid;
		this.n_aid = n_aid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.ninsertdate = ninsertdate;
		this.ndeletedate = ndeletedate;
	}



	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getN_aid() {
		return n_aid;
	}

	public void setN_aid(String n_aid) {
		this.n_aid = n_aid;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public Timestamp getNinsertdate() {
		return ninsertdate;
	}

	public void setNinsertdate(Timestamp ninsertdate) {
		this.ninsertdate = ninsertdate;
	}

	public Timestamp getNdeletedate() {
		return ndeletedate;
	}

	public void setNdeletedate(Timestamp ndeletedate) {
		this.ndeletedate = ndeletedate;
	}
	
	
}
