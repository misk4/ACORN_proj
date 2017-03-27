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

		
		//출석한 날짜를 출력하는 메서드
		public List<AttendanceDTO> getattendancedate(HashMap<String, String> map){
			SqlSession session = MySqlsessionFactory.openSession();
			List<AttendanceDTO> list = null;
			
			try {
				
				list=session.selectList("getattendancedate", map);
				
			} finally {
				session.close();
			}
			
			
			return list;
		}
	
	
	
		//異쒖꽍�븯湲�
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
		//異쒖꽍���굹 �솗�씤�븯�뒗 硫붿꽌�뱶(濡쒓렇�씤�떆 異쒖꽍�븯湲곕쾭�듉 異쒕젰�븷吏� 留먯� �씠嫄몃줈 寃곗젙)
		public List<AttendanceDTO> checkatten(HashMap<String, String> map){
			SqlSession session = MySqlsessionFactory.openSession();
			List<AttendanceDTO> list = null;
			System.out.println("�뱾�뼱媛��뒗 肄붿뒪�뜲�씠�듃:"+map.get("course_date"));
			try {
				
				list = session.selectList("attendancecheck", map);
			
			} finally {
				session.close();
			}
			
			return list;
		}
		//�궡 異쒖꽍由ъ뒪�듃蹂닿린
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
		//�궡 異쒖꽍�씪�닔 援ы븯�뒗 硫붿꽌�뱶
		public int getattendanceday(HashMap<String, String> map){
		SqlSession session = MySqlsessionFactory.openSession();
		int k = 0;	
		
		try {
		k = session.selectOne("getattendanceday", map);
			
		} finally {
		
		}	
		
		return k;
		}
		
		//愿�由ъ옄媛� �븰�깮�뱾 異쒖꽍紐⑸줉�쓣 蹂닿린�쐞�븳 硫붿꽌�뱶
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
}//end attendance�꽌鍮꾩뒪

