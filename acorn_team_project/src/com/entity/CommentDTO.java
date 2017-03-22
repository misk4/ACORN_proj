package com.entity;

public class CommentDTO {
	
	
		private int id;
		private String board_id;
		private String writer_id;
		private String content;
		private String written_date;
		
		public CommentDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CommentDTO(int id, String board_id, String writer_id, String content, String written_date) {
			super();
			this.id = id;
			this.board_id = board_id;
			this.writer_id = writer_id;
			this.content = content;
			this.written_date = written_date;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getBoard_id() {
			return board_id;
		}
		public void setBoard_id(String board_id) {
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
		@Override
		public String toString() {
			return "CommentDTO [id=" + id + ", board_id=" + board_id + ", writer_id=" + writer_id + ", content="
					+ content + ", written_date=" + written_date + "]";
		}
		
		
}
