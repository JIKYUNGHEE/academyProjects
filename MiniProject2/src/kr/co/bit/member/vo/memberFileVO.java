package kr.co.bit.member.vo;

public class memberFileVO {
	private int no;
	private String memberId;
	private String fileOriName;
	private String fileSaveName;
	private int fileSize;
	
	public memberFileVO() {
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}	
	public String getFileOriName() {
		return fileOriName;
	}
	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}
	public String getFileSaveName() {
		return fileSaveName;
	}
	public void setFileSaveName(String fileSaveName) {
		this.fileSaveName = fileSaveName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "memberFileVO [no=" + no + ", memberId=" + memberId + ", fileOriName=" + fileOriName + ", fileSaveName="
				+ fileSaveName + ", fileSize=" + fileSize + "]";
	}
	
}