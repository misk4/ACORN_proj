<%@page import="com.DAO.MySqlsessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.util.List"%>
<%@page import="com.service.CommentService"%>
<%@page import="com.entity.MemberDTO"%>
<%@page import="com.entity.CommentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
    <script type ="text/javascript">
    </script>
    
    <%
    String content=request.getParameter("content");
    String id=request.getParameter("id");
    String repRoot=request.getParameter("repRoot");
    String repStep=request.getParameter("repStep");
    String repIndent=request.getParameter("repIndent");
    String board_id=request.getParameter("board_id");
    String written_date=request.getParameter("written_date");
    
    
    CommentDTO CommentDTO=new CommentDTO();
    MemberDTO mdto = (MemberDTO)session.getAttribute("login");
    
    CommentDTO.setContent(content);
    CommentDTO.setWriter_id(mdto.getId());
    CommentDTO.setId(Integer.parseInt(id));
    CommentDTO.setWritten_date(written_date);
    CommentDTO.setRepRoot(Integer.parseInt(repRoot));
    CommentDTO.setRepStep(Integer.parseInt(repStep));
    CommentDTO.setRepIndent(Integer.parseInt(repIndent));
    CommentDTO.setBoard_id(Integer.parseInt(board_id));
    
   CommentService service=new CommentService();
   List<CommentDTO> commentList=null;
   
    SqlSession sess = MySqlsessionFactory.openSession();
    int result = 0;
    try{
     result = service.replyInsert(CommentDTO);
     
     commentList=service.commentList(Integer.parseInt(board_id));
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      sess.close();
   }
   
   
   %>

    
    <!-- Comment -->
   <c:forEach var="list" items="${commentList}">
      <div class="media">
         <c:forEach begin="0" end="${list.repIndent}">
    <a class="pull-left" href="#">
               <div class="media-object" >&nbsp;&nbsp;</div>
         
            </c:forEach>
          <a class="pull-left" href="#">
               <div class="media-object arrowdiv" ></div>
         </a>
         <div class="media-body">
          
            <h4 class="media-heading">
               By ${list.writer_id} <small>${list.written_date}</small>
            </h4>
            <pre>${list.content}</pre>
         <button class="replebutton btn btn-primary">댓글 달기</button>
         <br/><br/>
         <div class="reple well" style="display: none;">
            <h4>Leave a Comment:</h4>
            <form class="rprpform" name="rprpform" role="form" method="post">
               <div class="form-group">
                  <textarea name="rprpContent"class="form-control" rows="3"></textarea>
               </div>
               <input type="hidden" name="userid" value="${userid.id}">
               <input type="hidden" name="id" value="${list.id}">
               <input type="hidden" name="repRoot" value="${list.repRoot}">
               <input type="hidden" name="repStep" value="${list.repStep}">
               <input type="hidden" name="repIndent" value="${list.repIndent}">
               <input type="hidden" name="board_id" value="<%=board_id%>">
               <button type="submit" class="btn btn-primary">Submit</button>
            </form>
         </div>
         </div>
      </div>
      <hr>
   </c:forEach>
   <!-- Comment -->