package com.entity;

public class NewsArticleDTO {
	
	private String newscompany;
	private String newscategory;
	private String newsrssaddress;
	
	
	public String getNewscompany() {
		return newscompany;
	}
	public void setNewscompany(String newscompany) {
		this.newscompany = newscompany;
	}
	public String getNewscategory() {
		return newscategory;
	}
	public void setNewscategory(String newscategory) {
		this.newscategory = newscategory;
	}
	public String getNewsrssaddress() {
		return newsrssaddress;
	}
	public void setNewsrssaddress(String newsrssaddress) {
		this.newsrssaddress = newsrssaddress;
	}
	public NewsArticleDTO(String newscompany, String newscategory, String newsrssaddress) {
		super();
		this.newscompany = newscompany;
		this.newscategory = newscategory;
		this.newsrssaddress = newsrssaddress;
	}
	public NewsArticleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NewsArticleDTO [newscompany=" + newscompany + ", newscategory=" + newscategory + ", newsrssaddress="
				+ newsrssaddress + "]";
	}
	
	
	
	
}
