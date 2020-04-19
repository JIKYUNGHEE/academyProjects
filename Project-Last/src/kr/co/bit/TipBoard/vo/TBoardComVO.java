package kr.co.bit.TipBoard.vo;


//팁 게시판 답글VO
public class TBoardComVO {
	
	private String writer;
	private String regDate;
	private String title;
	private int no;
	private int viewCnt;
	private String content;
	private int commentNo;
	
	
	
	
	public TBoardComVO() {
		
	}
	@Override
	public String toString() {
		return "TBoardComVO [writer=" + writer + ", regDate=" + regDate + ", title=" + title + ", no=" + no
				+ ", viewCnt=" + viewCnt + ", content=" + content + ", commentNo=" + commentNo + "]";
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	

	
	
	
}
