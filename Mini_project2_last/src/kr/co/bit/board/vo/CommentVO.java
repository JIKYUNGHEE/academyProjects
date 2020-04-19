package kr.co.bit.board.vo;

public class CommentVO {

	private int cNo;
	private int boardNo;
	private String writer;
	private String content;
	private String regDate;
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentVO(int cNo, int boardNo, String writer, String content, String regDate) {
		super();
		this.cNo = cNo;
		this.boardNo = boardNo;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CommentVO [cNo=" + cNo + ", boardNo=" + boardNo + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
	
	
	
	
}
