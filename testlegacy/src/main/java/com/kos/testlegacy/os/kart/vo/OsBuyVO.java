package com.kos.testlegacy.os.kart.vo;

public class OsBuyVO {
	private String bnum;
	private String mid;
	private String lnum;
	private String lname;
	private String lcur;
	private String lfile;
	private String insertdate;
	private String updatedate;
	private String deledteyn;
	private String lhit;
	private String lprice;
	
	public OsBuyVO() {

	}
	
	public OsBuyVO(String bnum, String mid, String lnum, String lname, String lcur, String lfile, String insertdate,
			String updatedate, String deledteyn, String lhit, String lprice) {
	
		this.bnum = bnum;
		this.mid = mid;
		this.lnum = lnum;
		this.lname = lname;
		this.lcur = lcur;
		this.lfile = lfile;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.deledteyn = deledteyn;
		this.lhit = lhit;
		this.lprice = lprice;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getLnum() {
		return lnum;
	}

	public void setLnum(String lnum) {
		this.lnum = lnum;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLcur() {
		return lcur;
	}

	public void setLcur(String lcur) {
		this.lcur = lcur;
	}

	public String getLfile() {
		return lfile;
	}

	public void setLfile(String lfile) {
		this.lfile = lfile;
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

	public String getDeledteyn() {
		return deledteyn;
	}

	public void setDeledteyn(String deledteyn) {
		this.deledteyn = deledteyn;
	}

	public String getLhit() {
		return lhit;
	}

	public void setLhit(String lhit) {
		this.lhit = lhit;
	}

	public String getLprice() {
		return lprice;
	}

	public void setLprice(String lprice) {
		this.lprice = lprice;
	}
}
