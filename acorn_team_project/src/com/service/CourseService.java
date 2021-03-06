package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.DAO.MySqlsessionFactory;
import com.entity.CourseDTO;
import com.entity.ScheduleDTO;
import com.exception.CommonException;

import ch.qos.logback.core.net.SyslogOutputStream;

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

	public void deleteCourse(String[] ids) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<ids.length;i++){
			list.add(Integer.parseInt(ids[i]));
		}
		
		try{
			int n = session.delete(namespace+"deleteCourse",list );
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

	public List<CourseDTO> myCourse(List<CourseDTO> list,String id) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();

		List<Integer> mycourse = null;
		try{
			mycourse = session.selectList(namespace+"myCourse",id);
			for(CourseDTO dto:list){
				for (Integer integer : mycourse) {
					if(dto.getId()==integer){
						dto.setStatus(true);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("mypage 실패");
		}finally{
			session.close();
		}

		return list;
	}

	public List<CourseDTO> myCourseList(String id) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();

		List<CourseDTO> list = null;
		try{
			list = session.selectList(namespace+"myCourseList",id);

		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("mycourselist 실패");
		}finally{
			session.close();
		}

		return list;
	}



	public List<CourseDTO> teacherCourseList(String id) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();

		List<CourseDTO> list = null;
		try{
			list = session.selectList(namespace+"teacherCourseList",id);

		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("teachercourselist 실패");
		}finally{
			session.close();
		}

		return list;
	}

	public List<ScheduleDTO> scheduleList(String cid) throws CommonException{

		SqlSession session = MySqlsessionFactory.openSession();
		int course_id = Integer.parseInt(cid);
		List<ScheduleDTO> list = null;
		try{
			list = session.selectList(namespace+"scheduleList",course_id);
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("scheduleList 실패");
		}finally{
			session.close();
		}

		return list;

	}

	public void scheduleUpdate(ScheduleDTO dto) throws CommonException{

		SqlSession session = MySqlsessionFactory.openSession();
		try{
			int n = session.update(namespace+"scheduleUpdate",dto);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("scheduleList 실패");
		}finally{
			session.close();
		}


	}

	public void scheduleInsert(ScheduleDTO dto) throws CommonException{

		SqlSession session = MySqlsessionFactory.openSession();
		try{
			int n = session.insert(namespace+"scheduleInsert",dto);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("scheduleInsert 실패");
		}finally{
			session.close();
		}


	}
	
	public void scheduleDelete(String[] ids) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<ids.length;i++){
			list.add(Integer.parseInt(ids[i]));
		}
		
		try{
			int n = session.delete(namespace+"deleteSchedule",list );
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("일정 삭제 실패");
		}finally{

			session.close();
		}
	}
	
	public List<ScheduleDTO> getScheduleByCourse(String course_id) throws CommonException{
		SqlSession session = MySqlsessionFactory.openSession();
		List<ScheduleDTO> list = null;
		try{
			list = session.selectList(namespace+"getScheduleByCourse", Integer.parseInt(course_id));
		}catch(Exception e){
			e.printStackTrace();
			throw new CommonException("강의 수정 실패");
		}finally{

			session.close();
		}

		return list;
	}

}
