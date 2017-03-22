package com.entity;

public class CourseDTO {
	
	
	private int id;
	private String name;
	private String teacher_id;
	private String start_time;
	private String end_time;
	private String start_day;
	private String end_day;
	private String days;
	private String manager_id;
	private int max_student;
	private int total_days;
	
	private int current_student;
	private String teacher_name;
	
	
	
	
	public CourseDTO(int id, String name, String teacher_id,String start_time, String end_time, String start_day,
			String end_day, String days, String manager_id, int max_student, int total_days) {
		super();
		this.id = id;
		this.name = name;
		this.teacher_id = teacher_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.start_day = start_day;
		this.end_day = end_day;
		this.days = days;
		this.manager_id = manager_id;
		this.max_student = max_student;
		this.total_days = total_days;
	}
	
	public CourseDTO(int id, String name, String teacher_name, String start_time, String end_time, String start_day,
			String end_day, String days, String manager_id,int current_student, int max_student, int total_days) {
		super();
		this.id = id;
		this.name = name;
		this.teacher_name = teacher_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.start_day = start_day;
		this.end_day = end_day;
		this.days = days;
		this.manager_id = manager_id;
		this.current_student = current_student;
		this.max_student = max_student;
		this.total_days = total_days;
	}
	
	public CourseDTO(int id, String name, String teacher_id,String teacher_name, String start_time, String end_time, String start_day,
			String end_day, String days, String manager_id, int max_student, int total_days) {
		super();
		this.id = id;
		this.name = name;
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.start_day = start_day;
		this.end_day = end_day;
		this.days = days;
		this.manager_id = manager_id;
		this.max_student = max_student;
		this.total_days = total_days;
	}
	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getStart_day() {
		return start_day;
	}
	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}
	public String getEnd_day() {
		return end_day;
	}
	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public int getMax_student() {
		return max_student;
	}
	public void setMax_student(int max_student) {
		this.max_student = max_student;
	}
	
	
	public int getTotal_days() {
		return total_days;
	}
	public void setTotal_days(int total_days) {
		this.total_days = total_days;
	}
	
	public int getCurrent_student() {
		return current_student;
	}




	public void setCurrent_student(int current_student) {
		this.current_student = current_student;
	}




	public String getTeacher_name() {
		return teacher_name;
	}




	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}




	@Override
	public String toString() {
		return "CourseDTO [id=" + id + ", name=" + name + ", teacher_id=" + teacher_id + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", start_day=" + start_day + ", end_day=" + end_day + ", days=" + days
				+ ", manager_id=" + manager_id + ", max_student=" + max_student + ", total_days=" + total_days + "]";
	}
	
	
	
	
	
		
}
