package com.entity;

public class ScheduleDTO {

	private int id;
	private int course_id;
	private String course_date;
	private String content;
	private String filepath;
	
	public ScheduleDTO() {
		
	}
	
	

	public ScheduleDTO(int id, int course_id, String course_date, String content, String filepath) {
		super();
		this.id = id;
		this.course_id = course_id;
		this.course_date = course_date;
		this.content = content;
		this.filepath = filepath;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_date() {
		return course_date;
	}

	public void setCourse_date(String course_date) {
		this.course_date = course_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
	
	
}
