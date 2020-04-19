package kr.co.bit.marketBoard.vo;


//분양 게시판 VO
public class MBoardVO {
	
	private String writer;
	private String regDate;
	private String title;
	private int no;
	private int viewCnt;
	private String content;
	
	
	public MBoardVO() {

	}

	
	@Override
	public String toString() {
		return "TBoardVO [writer=" + writer + ", regDate=" + regDate + ", title=" + title + ", no=" + no + ", viewCnt="
				+ viewCnt + ", content=" + content + "]";
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
	
	
	
	
}
