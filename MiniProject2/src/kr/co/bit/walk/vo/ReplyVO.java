package kr.co.bit.walk.vo;

public class ReplyVO {

	private int reply_no;
	private int walk_no;
	private String id;
	private String reply_content;
	private String reg_date;
	private String info;
	private String nickname;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getWalk_no() {
		return walk_no;
	}
	public void setWalk_no(int walk_no) {
		this.walk_no = walk_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getInfo() {
		return toString();
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public ReplyVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "{\"nickname\" : \""+nickname+"\", \"reg_date\" :\""+reg_date+"\", \"reply_no\" :\"" + reply_no + "\", \"walk_no\" :\"" + walk_no +"\", \"id\" :\"" + id + 
				"\", \"reply_content\" :\"" + reply_content +"\"}";
	}

	
	
	
}
