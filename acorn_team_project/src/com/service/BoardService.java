package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.DAO.MySqlsessionFactory;
import com.entity.BoardDTO;
import com.entity.PageDTO;

public class BoardService {
	String namespace = "BoardMapper.";
	
	private int totalCount(){
		SqlSession session = MySqlsessionFactory.openSession();
		int count = 0;
		try{
			count = session.selectOne("totalCount");
		}finally {
			session.close();
		}
		return count;
		
	}
	
	//8. 페이징처리
	public PageDTO boardPage(int curPage){
		PageDTO page = new PageDTO();
		SqlSession session = MySqlsessionFactory.openSession();
		List<BoardDTO> list = null;
		int skip = (curPage -1) *page.getPerpage();
		try{
			list=session.selectList(namespace+"boardList",null,
					new RowBounds(skip,page.getPerpage()));
		
		}finally{
			session.close();
		}
		page.setList(list);
		page.setCurpage(curPage);
		page.setTotalcount(totalCount());
		return page;
	}
		
	 
		
		
		
	//7.검색
	public PageDTO boardSearch(HashMap<String,String>map,int curPage){
		/*SqlSession session = MySqlsessionFactory.openSession();
		List<BoardDTO> list = null;
		try{
			 list=  session.selectList(namespace+"boardSearch", map);
			 
		}finally {
							session.close();
			}
		return list;
		*/
		PageDTO page = new PageDTO();
		SqlSession session = MySqlsessionFactory.openSession();
		List<BoardDTO> list = null;
		int skip = (curPage -1) *page.getPerpage();
		try{
			list=session.selectList(namespace+"boardSearch",map,
					new RowBounds(skip,page.getPerpage()));
		
		}finally{
			session.close();
		}
		page.setList(list);
		page.setCurpage(curPage);
		page.setTotalcount(totalCount());
		return page;
	}
	
	//6. 수정
	public void boardUpdate(HashMap<String, String> map){
		 SqlSession session = MySqlsessionFactory.openSession();
			try{
   session.update(namespace+"boardUpdate", map);
   session.commit();
			}finally {
				session.close();
		}
	}
	
	
	
	//5. 삭제
	public void boardDelete(int id){
			SqlSession session = MySqlsessionFactory.openSession();
			try{
				session.delete(namespace+"boardDelete", id);
				session.commit();
			}finally{
				session.close();
			}
	}
	
	
	
	
	//4.조회수 증가
		public void boardReadcnt(int id){
			SqlSession session = MySqlsessionFactory.openSession();
			try{
		 session.update(namespace+"boardReadcnt",id);
		 session.commit();
			}finally {
				session.close();
			}
			
		}
	
	//3. 글 자세히 보기
		public BoardDTO boardInfo(int id){
			boardReadcnt(id);
			SqlSession session = MySqlsessionFactory.openSession();
			BoardDTO dto = null;
			try{
				dto= session.selectOne(namespace+"boardInfo",id);
			}finally{
				session.close();
			}
			return dto;
		}

		
	//2. 글쓰기
		public void boardWrite(BoardDTO dto){
			SqlSession session = MySqlsessionFactory.openSession();
		try{
			session.insert(namespace+"boardWrite",dto);
			session.commit();
		}finally{
			session.close();
		}
		}
	
	//1. 목록보기
	public List<BoardDTO> boardList(){
		SqlSession session = MySqlsessionFactory.openSession();
		List<BoardDTO> list = null;
		try{
			list=session.selectList(namespace+"boardList");
		}finally{
			session.close();
		}
		return list;
	}
	
	
	
}
