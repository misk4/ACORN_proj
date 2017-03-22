package com.entity;

public class StudentDTO extends MemberDTO{

	boolean isattendance;
	
	public boolean isIsattendance() {
		return isattendance;
	}

	public void setIsattendance(boolean isattendance) {
		this.isattendance = isattendance;
	}

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(String id, String name, String birthdate, String password, String gender, String phonenum,
			String email) {
		super(id, name, birthdate, password, gender, phonenum, email);
		// TODO Auto-generated constructor stub
	}
		

		
	
}
