package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.DAO.MySqlsessionFactory;
import com.entity.ManagerDTO;
import com.entity.MemberDTO;
import com.entity.StudentDTO;
import com.entity.TeacherDTO;

public class MemberService {
	
	public MemberDTO login(HashMap<String, String> map){
		SqlSession session = MySqlsessionFactory.openSession();
		MemberDTO dto = null;
		try{
			dto = session.selectOne("studentLogin",map); 
			if(dto==null){
				dto = session.selectOne("teacherLogin", map);
				if(dto==null){
					dto = session.selectOne("managerLogin", map);
				}
			}
		
				
		}finally {
			session.close();
		}
		
		return dto;
	}
	public void updatemember(HashMap<String, String> map){
		SqlSession session = MySqlsessionFactory.openSession();
		
		try {
			session.update("studentUpdate", map);
			session.commit();
		} finally {
			session.close();
		}
	}
		public void updatememberfrommanager(HashMap<String, String> map){
			SqlSession session = MySqlsessionFactory.openSession();
			
			try {
				session.update("updatememberfrommanager", map);
				session.commit();
			} finally {
				session.close();
			}
		
		
		
	}
	public List<MemberDTO> getallstudentlist(){
		SqlSession session = MySqlsessionFactory.openSession();
		List<MemberDTO> list = null;
		try {
			list = session.selectList("getallstudentlist");
			
		} finally {
			session.close();
			
		}
		
		return list;
	}
	
	public List<MemberDTO> getallteacherlist(){
		SqlSession session = MySqlsessionFactory.openSession();
		List<MemberDTO> list = null;
		try {
			list = session.selectList("getallteacherlist");
			
		} finally {
			session.close();
			
		}
		
		return list;
	}
	public List<MemberDTO> watingjoinlist(){
		SqlSession session = MySqlsessionFactory.openSession();
		List<MemberDTO> list = null;
		try {
			list = session.selectList("watingjoinlist");
			
		} finally {
			session.close();
			
		}
		
		return list;
	}
	//등급올려주는 메서드
	public int updateconfirmation(String id){
		SqlSession session = MySqlsessionFactory.openSession();
		int k = 0;
		try {
			
			k = session.update("updateconfirmation", id);
			session.commit();
		}catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		return k;
	}
	//회원가입 메서드
	public int joinmember(HashMap<String, String> map){
		SqlSession session = MySqlsessionFactory.openSession();
		int k = 0;
		try {
			k=session.update("joinstudent", map);
			session.commit();
		}catch(Exception e){
			session.rollback();
		}
		finally {
			session.commit();
		}
		
		return k;
	}
	public int idcheck(String id){
		SqlSession session = MySqlsessionFactory.openSession();
		int k = 0;
		String checkid = null;
		try {
		checkid = session.selectOne("idcheck", id);
			
		} finally {
			session.close();
		}
		
		if(checkid!=null){
			k = 1;
		}
		
		return k;
	}
	
}
