package kr.co.bit.TipBoard.vo;

//팁 게시판 댓글 VO
public class TBoardRepVO {
	
	private String writer;
	private String regDate;
	private int no;
	private String content;
	private int replyNo;
	
	
	@Override
	public String toString() {
		return "TBoardRepVO [writer=" + writer + ", regDate=" + regDate + ", no=" + no + ", content=" + content
				+ ", replyNo=" + replyNo + "]";
	}

	public TBoardRepVO() {
		
	}
	
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	
	
	
	
	
	

}
