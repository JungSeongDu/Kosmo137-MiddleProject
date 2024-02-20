package com.kos.testlegacy.os.lecture.vo;

public class OsLectureVO {
	private String lnum;
	private String lname;
	private String lcur;
	private String lfile;
	private String insertdate;
	private String updatedate;
	private String deleteyn;
	private String lhit;
	private String lprice;
	private String lbuy;
	
	//패이징
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	
	private   String keyword;
	private   String searchFilter;
	private   String searchValue;
		
	// 조회수 필드
	private int bhit;
		
	   
	public OsLectureVO() {
		
	}

	public OsLectureVO(String lnum, String lname, String lcur, String lfile, String insertdate, String updatedate,
			String deleteyn, String lhit, String lprice, String lbuy, String pageSize, String groupSize, String curPage,
			String totalCount, String keyword, String searchFilter, String searchValue, int bhit) {
		super();
		this.lnum = lnum;
		this.lname = lname;
		this.lcur = lcur;
		this.lfile = lfile;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.deleteyn = deleteyn;
		this.lhit = lhit;
		this.lprice = lprice;
		this.lbuy = lbuy;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.searchValue = searchValue;
		this.bhit = bhit;
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

	public String getDeleteyn() {
		return deleteyn;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
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

	public String getLbuy() {
		return lbuy;
	}

	public void setLbuy(String lbuy) {
		this.lbuy = lbuy;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}

	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}
