package com.kos.testlegacy.os.kart.vo;

public class OsKartVO {
	
	private String knum;
	private String lname;
	private String lprice;
	private String lfile;
	private String lcur;
	

	private String lpricesum;
	private String lnum;
	private String mnum;
	private String deleteyn;

	public OsKartVO(){
		
	}
	
public OsKartVO(String knum,String lname,String lprice,String lfile,String lcur,String lpricesum,String lnum,String mnum,String deleteyn){
		
	this.knum = knum;
	this.lname = lname;
	this.lprice = lprice;
	this.lfile = lfile;
	this.lcur = lcur;
	this.lpricesum = lpricesum;
	this.lnum = lnum;
	this.mnum = mnum;
	this.deleteyn = deleteyn;
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
public String getKnum() {
	return knum;
}

public void setKnum(String knum) {
	this.knum = knum;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getLprice() {
	return lprice;
}

public void setLprice(String lprice) {
	this.lprice = lprice;
}

public String getLpricesum() {
	return lpricesum;
}

public void setLpricesum(String lpricesum) {
	this.lpricesum = lpricesum;
}

public String getLnum() {
	return lnum;
}

public void setLnum(String lnum) {
	this.lnum = lnum;
}

public String getMnum() {
	return mnum;
}

public void setMnum(String mnum) {
	this.mnum = mnum;
}

public String getDeleteyn() {
	return deleteyn;
}

public void setDeleteyn(String deleteyn) {
	this.deleteyn = deleteyn;
}
	


}
