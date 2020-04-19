package kr.co.bit.like.vo;

public class LikeFileVO {

	private int no;
	private int like_no;
	private String oriname;
	private String savename;
	private int fsize;
	
	
	
	public int getLike_no() {
		return like_no;
	}
	public void setLike_no(int like_no) {
		this.like_no = like_no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public int getFsize() {
		return fsize;
	}
	public void setFsize(int fsize) {
		this.fsize = fsize;
	}
	public LikeFileVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LikeFileVO [no=" + no + ", like_no=" + like_no + ", oriname=" + oriname + ", savename=" + savename
				+ ", fsize=" + fsize + "]";
	}
	
	
	
}
