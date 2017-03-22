package com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.DAO.MySqlsessionFactory;
import com.entity.AttendanceDTO;
import com.entity.MemberDTO;
import com.entity.StudentDTO;
import com.entity.StudentattendancelistDTO;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

public class AttendanceService {

		
	
	
		//출석하기
		public int insertattendance(HashMap<String, String> map){
			SqlSession session = MySqlsessionFactory.openSession();
			System.out.println(map.get("tag_time"));
			System.out.println(map.get("course_date"));
			int k = 0;
			try{
			k=session.insert("insertattendance", map);
			session.commit();
			
			}finally{
				session.close();
			}
			
		return k;
		
		}
		//출석헀나 확인하는 메서드(로그인시 출석하기버튼 출력할지 말지 이걸로 결정)
		public List<AttendanceDTO> checkatten(HashMap<String, String> map){
			SqlSession session = MySqlsessionFactory.openSession();
			List<AttendanceDTO> list = null;
			System.out.println("들어가는 코스데이트:"+map.get("course_date"));
			try {
				
				list = session.selectList("attendancecheck", map);
			
			} finally {
				session.close();
			}
			
			return list;
		}
		//내 출석리스트보기
		public List<AttendanceDTO> getattenlist(String student_id){
			SqlSession session = MySqlsessionFactory.openSession();
			List<AttendanceDTO> list = null;
			try {
				list = session.selectList("getattenlist", student_id);
				
			} finally {
				session.close();
			}
			
			return list;
		}
		//내 출석일수 구하는 메서드
		public int getattendanceday(HashMap<String, String> map){
		SqlSession session = MySqlsessionFactory.openSession();
		int k = 0;	
		
		try {
		k = session.selectOne("getattendanceday", map);
			
		} finally {
		
		}	
		
		return k;
		}
		
		//관리자가 학생들 출석목록을 보기위한 메서드
		public List<StudentattendancelistDTO> studentattendancelist(String today){
			SqlSession session = MySqlsessionFactory.openSession();
			List<StudentattendancelistDTO> list= null;
			try {
				
				list = session.selectList("studentattendancelist",today);
				
			} finally {
				session.close();
			}
			return list;
		}
		
		public List<StudentDTO> getabsencelist(String today){
			SqlSession session = MySqlsessionFactory.openSession();
			List<StudentDTO> list = null;
			
			try {
				list = session.selectList("getabsencelist", today);
				
			} finally {
				session.close();
			}
		
			
			return list;
		}
}//end attendance서비스

