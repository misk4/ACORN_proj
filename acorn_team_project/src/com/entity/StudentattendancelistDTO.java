package com.entity;

public class StudentattendancelistDTO {


	
	//관리자가 학생출석목록을 보기위한 디티오
	
	
	private String name;
	private String Student_id;
	private String course_id;
	private String tag_time;
	private String course_date;
	
	
	
	@Override
	public String toString() {
		return "Studentattendancelist [name=" + name + ", Student_id=" + Student_id + ", course_id=" + course_id
				+ ", tag_time=" + tag_time + ", course_date=" + course_date + "]";
	}
	public StudentattendancelistDTO(String name, String student_id, String course_id, String tag_time,
			String course_date) {
		super();
		this.name = name;
		Student_id = student_id;
		this.course_id = course_id;
		this.tag_time = tag_time;
		this.course_date = course_date;
	}
	public StudentattendancelistDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(String student_id) {
		Student_id = student_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getTag_time() {
		return tag_time;
	}
	public void setTag_time(String tag_time) {
		this.tag_time = tag_time;
	}
	public String getCourse_date() {
		return course_date;
	}
	public void setCourse_date(String course_date) {
		this.course_date = course_date;
	}
	
		
}
