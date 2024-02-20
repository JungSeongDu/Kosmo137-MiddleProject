package com.kos.testlegacy.os.rboard.vo;

public class OsRboardVO {
	
	private String rbnum;
	private String bnum;
	private String rbname;
	private String rbcontent;		
	private String insertdate;
	
	// 생성자 
	public OsRboardVO() {
	
	}

	public OsRboardVO(String rbnum, String bnum, String rbname, String rbcontent, String insertdate) {
	
		this.rbnum = rbnum;
		this.bnum = bnum;
		this.rbname = rbname;
		this.rbcontent = rbcontent;
		this.insertdate = insertdate;
	}
	
	// setter / getter
	public String getRbnum() {
		return rbnum;
	}
	public String getBnum() {
		return bnum;
	}
	public String getRbname() {
		return rbname;
	}
	public String getRbcontent() {
		return rbcontent;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public void setRbnum(String rbnum) {
		this.rbnum = rbnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public void setRbname(String rbname) {
		this.rbname = rbname;
	}
	public void setRbcontent(String rbcontent) {
		this.rbcontent = rbcontent;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	
	
}
