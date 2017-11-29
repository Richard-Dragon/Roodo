package com.xhhy.util;

public class PageUtil {
	private int pageNum;
	private int pageRows;
	private int totleRows;
	private int totlePages;
	
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PageUtil(int pageNum, int pageRows, int totleRows) {
		super();
		this.pageNum = pageNum;
		this.pageRows = pageRows;
		this.totleRows = totleRows;
		this.totlePages = totleRows%pageRows==0?totleRows/pageRows:totleRows/pageRows+1;
	}

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getTotleRows() {
		return totleRows;
	}
	public void setTotleRows(int totleRows) {
		this.totleRows = totleRows;
	}
	public int getTotlePages() {
		return totlePages;
	}
	public void setTotlePages(int totlePages) {
		this.totlePages = totlePages;
	}
	

}
