package com.article.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.DAO.MySqlsessionFactory;
import com.entity.ArticleCommentDTO;
import com.entity.NewsArticleDTO;

public class Articleservice {

	
	public NewsArticleDTO getrssaddress(HashMap<String, String> map){
		
		SqlSession session = MySqlsessionFactory.openSession();
		NewsArticleDTO dto = null;
		try {
			dto = session.selectOne("getrssaddress",map);
			
		}finally {
			session.close();
			
		}
		
		return dto;
	}
	public String urlreader(HashMap<String, String> map){
		StringBuffer sb = new StringBuffer();
		String readurl = "";
		
		if(map.get("link")==null){
			//rss주소 불러와주는 메서드
		NewsArticleDTO dto = getrssaddress(map);
		readurl=dto.getNewsrssaddress();
		}else{
			readurl=map.get("link");
		}
		InputStreamReader isr = null;
		BufferedReader bf = null;
		
			try {
				URL url = new URL(readurl);
				URLConnection urlconn = url.openConnection();
				InputStream is = urlconn.getInputStream();
				isr = new InputStreamReader(is,"UTF-8");
				bf = new BufferedReader(isr);
				String str;
				while((str=bf.readLine()) !=null ){
					
					sb.append(str+"\n\r");
				}
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(bf != null) try{bf.close();}catch(IOException e){}
				if(isr != null) try{isr.close();}catch(IOException e){}

	
			}
		
		return sb.toString();
	}
	
	public List<ArticleCommentDTO> getarticlecommentlist(HashMap<String, String> map){
		SqlSession session = MySqlsessionFactory.openSession();
		List<ArticleCommentDTO> list = null;
		try{
			list = session.selectList("getarticlecommentlist", map);
			System.out.println("댓글사이즈"+list.size());
			
		}finally{
			
			session.close();
		}
		
		return list;
		
	}
	//댓글등록
	public void writecomment(HashMap<String, String> map){
		SqlSession session = MySqlsessionFactory.openSession();
		
		try {
			session.insert("writecomment", map);
			session.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		
		finally {
			session.close();
		}
		
		
		
	}
}
