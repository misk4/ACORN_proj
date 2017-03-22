package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.DAO.MySqlsessionFactory;
import com.entity.CourseDTO;
import com.exception.CommonException;

public class CourseService {

	String namespace = "CourseMapper.";

	public List<CourseDTO> getCourseList() throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();

		List<CourseDTO> list = null;
		try{
			list = session.selectList(namespace+"courseList");
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("mypage 실패");
		}finally{
			session.close();
		}

		return list;
	}

	public void registerCourse(CourseDTO course) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();

		try{
			int n = session.insert(namespace+"registerCourse", course);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("강의 등록 실패");
		}finally{

			session.close();
		}
	}

	public void deleteCourse(int id) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();

		try{
			int n = session.delete(namespace+"deleteCourse", id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("강의 등록 실패");
		}finally{

			session.close();
		}
	}
	
	public void updateCourse(CourseDTO course) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();

		try{
			int n = session.update(namespace+"updateCourse", course);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("강의 수정 실패");
		}finally{

			session.close();
		}
	}
	
	public CourseDTO getCourseById(String id) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();
		CourseDTO dto = null;
		try{
			 dto = session.selectOne(namespace+"getCourseById", Integer.parseInt(id));
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("강의 수정 실패");
		}finally{

			session.close();
		}
		
		return dto;
	}
	
	public void applyCourse(String student_id,String course_id) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();
		CourseDTO dto = null;
		HashMap<String,String> map = new HashMap<>();
		map.put("student_id", student_id);
		map.put("course_id", course_id);
		int check = 0;
		try{
			check = session.selectOne(namespace+"applyCheck", map);
			if(check!=0){
				throw new CommonException("강의 이미 수강중");
			}
			check = 0;
			
			int n =session.insert(namespace+"applyCourse",map);
			session.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("강의 수강 신청 실패");
		}finally{

			session.close();
		}
	
	}

}
