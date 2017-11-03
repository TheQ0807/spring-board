package com.sample.web.pagination;

public class Pagination {

	private Integer rows = 5;
	private Integer pages = 5;
	private Integer pageNo = 1;
	private String opt;
	private String keyword;
	
	private int totalRows;
	
	public int getBeginIndex() {
		return (pageNo -1) * rows +1;
	}
	
	public int getEndIndex() {
		return pageNo * rows;
	}
	
	public int getTotalPages() {
		return (int) Math.ceil((double) totalRows/rows);
	}
	
	public int getTotalBlocks() {
		return (int) Math.ceil((double) getTotalPages()/pages);
	}
	
	public int getCurrentBlock() {
		return (int) Math.ceil((double) pageNo/pages);
	}
	public int getBeginPage() {
		return (getCurrentBlock() -1)* pages+1;
	}
	public int getEndPage() {
		if(getCurrentBlock() == getTotalBlocks()) {
			return getTotalPages();
		}
		return getCurrentBlock() * pages;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	
	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	@Override
	public String toString() {
		return "Pagination [rows=" + rows + ", pages=" + pages + ", pageNo=" + pageNo + ", opt=" + opt + ", keyword="
				+ keyword + ", totalRows=" + totalRows + "]";
	}

	
	
	
	
	
}
