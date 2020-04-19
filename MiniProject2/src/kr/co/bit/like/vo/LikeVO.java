package kr.co.bit.like.vo;

public class LikeVO {

	private int like_no;
	private String id;
	private String pName;
	private String pIntro;
	private String title;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLike_no() {
		return like_no;
	}
	public void setLike_no(int like_no) {
		this.like_no = like_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpIntro() {
		return pIntro;
	}
	public void setpIntro(String pIntro) {
		this.pIntro = pIntro;
	}
	public LikeVO() {
	}
	@Override
	public String toString() {
		return "LikeVO [like_no=" + like_no + ", id=" + id + ", pName=" + pName + ", pIntro=" + pIntro + ", title="
				+ title + "]";
	}
	
	
	
	
	
}
