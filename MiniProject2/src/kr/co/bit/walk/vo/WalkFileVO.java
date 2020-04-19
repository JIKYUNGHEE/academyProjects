package kr.co.bit.walk.vo;

public class WalkFileVO {

	private int file_no;
	private int walk_no;
	private String oriname;
	private String savename;
	private int fsize;
	
	
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public int getWalk_no() {
		return walk_no;
	}
	public void setWalk_no(int walk_no) {
		this.walk_no = walk_no;
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
	public WalkFileVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WalkFileVO [file_no=" + file_no + ", walk_no=" + walk_no + ", oriname=" + oriname + ", savename="
				+ savename + ", fsize=" + fsize + "]";
	}
	
	
	
}
