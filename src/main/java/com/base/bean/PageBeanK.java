package com.base.bean;

import java.util.ArrayList;
import java.util.List;

public class PageBeanK {
private Integer page = 0;
	
	private Integer rows = 10;
	
	private Integer allPage=0;
	
	private Integer allCount=0;
	
	private  List data=new ArrayList();
	
	//按那个字段排序
	private String sort; 
	//是desc or  asc
	private String order;
	//是否作废分页，就是不启分页的意思
	private Integer pageLose = 0;
	
	
	
	
	
	

	public Integer getPageLose() {
		return pageLose;
	}

	public void setPageLose(Integer pageLose) {
		this.pageLose = pageLose;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int start(){
		return (getPageNo()-1)*getPageSize();
	}

	public Integer getPageNo() {
		if(page>allPage){
			page=allPage;
		}
		return page;
	}

	public void setPageNo(Integer pageNo) {
		if(pageNo<0){
			pageNo=0;
		}
		this.page = pageNo;
	}

	public Integer getPageSize() {
		return rows;
	}

	public void setPageSize(Integer pageSize) {
		this.rows = pageSize;
	}

	public Integer getAllPage() {
		return allPage;
	}

	public void setAllPage(Integer allPage) {
		this.allPage = (allPage-1)/rows+1;
	}

	public Integer getAllCount() {
		return allCount;
	}

	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
		this.setAllPage(allCount);
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	
	
	
}
