package kr.co.bit.TipBoard.vo;


//팁 게시판 파일 VO
public class TBoardFileVO {
	
	private int no;
	private String fileOriName;
	private String fileSaveName;
	private int fileSize;
	private int fileNo;
	
	
	
	@Override
	public String toString() {
		return "TBoardFileVO [no=" + no + ", fileOriName=" + fileOriName + ", fileSaveName=" + fileSaveName
				+ ", fileSize=" + fileSize + ", fileNo=" + fileNo + "]";
	}
	public TBoardFileVO() {
	
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	
	
	
	
	

}
