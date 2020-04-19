package kr.co.bit.board.vo;

public class ReplyVO {
	
	private int reply_no;
	private int board_no;
	private String id;
	private String reply_date;
	private String reply_content;
	private String info;
	
	
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
		
	
	
	public ReplyVO() {
		
	}
	
	
	public ReplyVO(int reply_no, int board_no, String id, String reply_date, String reply_content) {
		
		this.reply_no = reply_no;
		this.board_no = board_no;
		this.id = id;
		this.reply_date = reply_date;
		this.reply_content = reply_content;
	}
	
	@Override
	public String toString() {
					
		return "{\"reply_no\" : \"" + reply_no + "\", \"board_no\" : \"" + board_no + "\", \"id\" : \"" + id + "\", \"reply_content\" : \"" + reply_content
				+ "\", \"reply_date\" : \"" + reply_date + "\"}";
		
		
		/*return "{\"reply_no\" : \"" + reply_no + "\", \"board_no\" : \"" + board_no + "\", \"id\" : \"" + id + "\", \"reply_date\" : \"" + reply_date
				+ "\", \"reply_content\" : \"" + reply_content + "\"}";*/
	}
	
	
	public String getInfo() {
		info=toString();
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
	
	
	
	
	
}
