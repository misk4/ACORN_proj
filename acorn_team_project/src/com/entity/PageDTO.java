package com.entity;

import java.util.ArrayList;
import java.util.List;

public class PageDTO {

	private List<BoardDTO> list;
	private int curpage;
	private int perpage=10;
	private int totalcount;
	private int maxpagenumber;
	
	
	
	public PageDTO(List<BoardDTO> list, int curpage, int perpage, int totalcount, int maxpagenumber) {
		super();
		this.list = list;
		this.curpage = curpage;
		this.perpage = perpage;
		this.totalcount = totalcount;
		this.maxpagenumber = maxpagenumber;
	}
	public PageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	public int getCurpage() {
		return curpage;
	}
	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}
	public int getPerpage() {
		return perpage;
	}
	public void setPerpage(int perpage) {
		this.perpage = perpage;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getMaxpagenumber() {
		return maxpagenumber;
	}
	public void setMaxpagenumber(int maxpagenumber) {
		this.maxpagenumber = maxpagenumber;
	}
	@Override
	public String toString() {
		return "PageDTO [list=" + list + ", curpage=" + curpage + ", perpage=" + perpage + ", totalcount=" + totalcount
				+ ", maxpagenumber=" + maxpagenumber + "]";
	}
	
	
	
	
	
}
