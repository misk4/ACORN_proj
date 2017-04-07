package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.DAO.MySqlsessionFactory;
import com.entity.CommentDTO;

public class CommentService {
   
   
   String namespace="CommentMapper.";
   
   
   public void replyWrite(CommentDTO dto){
      SqlSession session = MySqlsessionFactory.openSession();
      try{
    session.insert(namespace+"replyWrite", dto);
    session.commit();
      }finally {
         session.close();
      }
      
   }//end boardWrite
   
   public int replyUpdate(CommentDTO dto){
      int n=0;
      SqlSession session = MySqlsessionFactory.openSession();
      try{
    n=session.insert(namespace+"replyUpdate", dto);
    session.commit();
      }finally {
         session.close();
      }
      return n;
   }
   public int replyInsert(CommentDTO dto){
      int n=0;
      int m=replyUpdate(dto);
      SqlSession session = MySqlsessionFactory.openSession();
      try{
         n=session.insert(namespace+"replyInsert", dto);
         session.commit();
      }finally {
         session.close();
      }
   return n+m;
   }
   
   
   
   public List<CommentDTO> commentList(int board_id){
       SqlSession session = MySqlsessionFactory.openSession();
       List<CommentDTO> list = null;
         try{
               list = session.selectList(namespace+"commentList", board_id);
         }finally {
            session.close();
         }
         return list;
   }
}