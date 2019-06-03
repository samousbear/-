package com.woniu.bean;

import java.util.List;

public class PageBean {
	private Integer pageNum;
	private Integer pageRow;
	private Integer countRow;
	private Integer countPage;
	private List list;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageRow() {
		return pageRow;
	}
	public void setPageRow(Integer pageRow) {
		this.pageRow = pageRow;
	}
	public Integer getCountRow() {
		return countRow;
	}
	public void setCountRow(Integer countRow) {
		this.countRow = countRow;
	}
	public Integer getCountPage() {
		return countPage;
	}
	public void setCountPage(Integer countPage) {
		this.countPage = countPage;
	}
	
}
