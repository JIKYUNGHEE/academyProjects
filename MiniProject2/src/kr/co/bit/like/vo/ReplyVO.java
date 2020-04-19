package kr.co.bit.like.vo;

public class ReplyVO {

	private int no;
	private int like_no;
	private String info;
	private String id;
	private String content;
	private String nickname;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getInfo() {
		
		info = toString();
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ReplyVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "{\"nickname\" : \""+nickname+"\", \"no\" : \"" + no + "\", \"like_no\" :\"" + like_no +"\", \"id\" :\"" + id + 
				"\", \"content\" :\"" + content +"\"}";
	}
	
	   
	  
}
