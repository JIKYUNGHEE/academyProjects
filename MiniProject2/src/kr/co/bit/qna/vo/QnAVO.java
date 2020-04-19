package kr.co.bit.qna.vo;

public class QnAVO {

	private int no;
	private String title;
	private String writer;
	private String content1;//작성자 내용
	private String content2;//관리자 답변
	private String regDate1;
	private String regDate2;
	private String info;

		
	public QnAVO() {
		
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getRegDate1() {
		return regDate1;
	}
	public void setRegDate1(String regDate) {
		this.regDate1 = regDate;
	}

	public String getRegDate2() {
		return regDate2;
	}

	public void setRegDate2(String regDate2) {
		this.regDate2 = regDate2;
	}
	
	@Override
	public String toString() {
		return "{\"no\" : \"" + no + "\", \"writer\" : \"" + writer + "\", \"title\" : \"" + title + "\", \"content1\" : \"" + content1 +"\", \"content2\" : \""
				+ content2 + "\", \"regDate1\" : \"" + regDate1 + "\", \"regDate2\" : \"" + regDate2 + "\"}";
	}

	public String getInfo() {
		info=toString();
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}	
	
}