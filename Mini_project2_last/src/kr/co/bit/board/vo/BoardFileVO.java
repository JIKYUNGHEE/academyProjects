package kr.co.bit.board.vo;

public class BoardFileVO {
	private int no;
	private int boardNo;
	private String oriName;
	private String saveName;
	private int fileSize;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public BoardFileVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardFileVO(int no, int boardNo, String oriName, String saveName, int fileSize) {
		super();
		this.no = no;
		this.boardNo = boardNo;
		this.oriName = oriName;
		this.saveName = saveName;
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		return "BoardFileVO [no=" + no + ", boardNo=" + boardNo + ", oriName=" + oriName + ", saveName=" + saveName
				+ ", fileSize=" + fileSize + "]";
	}
	
	
	

}
