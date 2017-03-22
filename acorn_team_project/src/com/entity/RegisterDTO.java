package com.entity;

public class RegisterDTO {
	
	
	private int id;
	private String student_id;
	private String course_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public RegisterDTO(int id, String student_id, String course_id) {
		super();
		this.id = id;
		this.student_id = student_id;
		course_id = course_id;
	}
	public RegisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RegisterDTO [id=" + id + ", student_id=" + student_id + ", Course_id=" + course_id + "]";
	}
	
	
}
