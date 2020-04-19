package kr.co.bit.board.vo;

public class BoardVO {
	private String type;
	private int no;
	private int bNo;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private String regDate;
	private int re;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public int getRe() {
		return re;
	}
	public void setRe(int re) {
		this.re = re;
	}
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoardVO(int no, String title, String writer, String regDate) {
	      // TODO Auto-generated constructor stub
	      this.no = no;
	      this.title = title;
	      this.writer = writer;
	      this.regDate = regDate;
	   
	 }
	public BoardVO(String type, int no, int bNo, String title, String writer, String content, int viewCnt,
			String regDate, int re) {
		super();
		this.type = type;
		this.no = no;
		this.bNo = bNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
		this.re = re;
	}
	@Override
	public String toString() {
		return "BoardVO [type=" + type + ", no=" + no + ", bNo=" + bNo + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", viewCnt=" + viewCnt + ", regDate=" + regDate + ", re=" + re + "]";
	}
	
	
	
	
	

}
