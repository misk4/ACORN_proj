package com.entity;

public class CommentDTO {
   
   
      private int id;
      private int board_id;
      private String writer_id;
      private String content;
      private String written_date;
      private int repRoot;
      private int repStep;
      private int repIndent;
      public CommentDTO() {
         super();
         // TODO Auto-generated constructor stub
      }
      public CommentDTO(int id, int board_id, String writer_id, String content, String written_date, int repRoot,
            int repStep, int repIndent) {
         super();
         this.id = id;
         this.board_id = board_id;
         this.writer_id = writer_id;
         this.content = content;
         this.written_date = written_date;
         this.repRoot = repRoot;
         this.repStep = repStep;
         this.repIndent = repIndent;
      }
      public int getId() {
         return id;
      }
      public void setId(int id) {
         this.id = id;
      }
      public int getBoard_id() {
         return board_id;
      }
      public void setBoard_id(int board_id) {
         this.board_id = board_id;
      }
      public String getWriter_id() {
         return writer_id;
      }
      public void setWriter_id(String writer_id) {
         this.writer_id = writer_id;
      }
      public String getContent() {
         return content;
      }
      public void setContent(String content) {
         this.content = content;
      }
      public String getWritten_date() {
         return written_date;
      }
      public void setWritten_date(String written_date) {
         this.written_date = written_date;
      }
      public int getRepRoot() {
         return repRoot;
      }
      public void setRepRoot(int repRoot) {
         this.repRoot = repRoot;
      }
      public int getRepStep() {
         return repStep;
      }
      public void setRepStep(int repStep) {
         this.repStep = repStep;
      }
      public int getRepIndent() {
         return repIndent;
      }
      public void setRepIndent(int repIndent) {
         this.repIndent = repIndent;
      }
      @Override
      public String toString() {
         return "CommentDTO [id=" + id + ", board_id=" + board_id + ", writer_id=" + writer_id + ", content="
               + content + ", written_date=" + written_date + ", repRoot=" + repRoot + ", repStep=" + repStep
               + ", repIndent=" + repIndent + "]";
      }
      
      
}    