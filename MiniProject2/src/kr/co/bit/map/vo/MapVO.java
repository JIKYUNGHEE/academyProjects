package kr.co.bit.map.vo;

public class MapVO {
	
	private String meetingTime;
	private String parkName;
	private String userId;
	private String userNickname;
	private String fileSaveName;
	private String info;
	
	public String getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getFileSaveName() {
		return fileSaveName;
	}
	public void setFileSaveName(String fileSaveName) {
		this.fileSaveName = fileSaveName;
	}
	public String getInfo() {
		info=toString();
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "{\"meetingTime\" : \""+meetingTime+"\", \"fileSaveName\" : \""+fileSaveName+"\", \"userNickname\" : \""+userNickname+"\"}";
	}
	
	
}
