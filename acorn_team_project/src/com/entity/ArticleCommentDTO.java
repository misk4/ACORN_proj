package com.entity;

public class ArticleCommentDTO {

	
	private String commentid;
	private String author;
	private String content;
	private String root;
	private String indent;
	private String commentlevel;
	
	
	
	
	@Override
	public String toString() {
		return "ArticleCommentDTO [commentid=" + commentid + ", author=" + author + ", content=" + content + ", root="
				+ root + ", indent=" + indent + ", commentlevel=" + commentlevel + "]";
	}
	public ArticleCommentDTO(String commentid, String author, String content, String root, String indent,
			String commentlevel) {
		super();
		this.commentid = commentid;
		this.author = author;
		this.content = content;
		this.root = root;
		this.indent = indent;
		this.commentlevel = commentlevel;
	}
	public ArticleCommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getIndent() {
		return indent;
	}
	public void setIndent(String indent) {
		this.indent = indent;
	}
	public String getCommentlevel() {
		return commentlevel;
	}
	public void setCommentlevel(String commentlevel) {
		this.commentlevel = commentlevel;
	}
	
}
