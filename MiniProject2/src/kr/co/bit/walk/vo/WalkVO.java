package kr.co.bit.walk.vo;

public class WalkVO {

	private int walk_no;
	private String title;
	private String content;
	private String reg_date;
	public int getWalk_no() {
		return walk_no;
	}
	public void setWalk_no(int walk_no) {
		this.walk_no = walk_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public WalkVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WalkVO [walk_no=" + walk_no + ", title=" + title + ", content=" + content + ", reg_date=" + reg_date
				+ "]";
	}

	
	


}
