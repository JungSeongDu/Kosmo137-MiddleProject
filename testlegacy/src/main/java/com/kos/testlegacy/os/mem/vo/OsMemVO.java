package com.kos.testlegacy.os.mem.vo;

public class OsMemVO {
	String knum;
	String mid;
	String mpw;
	String mname;
	String mtel;
	String memail;
	String deleteyn;
	String insertdate;
	String updatedate;
	
	public OsMemVO() {
		
	}

	public OsMemVO(String knum, String mid, String mpw, String mname, String mtel, String memail, String deleteyn,
			String insertdate, String updatedate) {
		super();
		this.knum = knum;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mtel = mtel;
		this.memail = memail;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

	public String getKnum() {
		return knum;
	}

	public void setKnum(String knum) {
		this.knum = knum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	
	
	
}
