package kr.co.bit.user.vo;

public class UserVO {
	
	private String id;
	private String password;
	private String nickname;
	private String email_id;
	private String email_domain;
	private String type;				// 사용자 U, 관리자 S
	private String gender;				// 남자 M, 여자 F
	private String sign_type;			// 일반 B, 카카오 K
	private String reg_date;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getEmail_domain() {
		return email_domain;
	}

	public void setEmail_domain(String email_domain) {
		this.email_domain = email_domain;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", nickname=" + nickname + ", email_id=" + email_id
				+ ", email_domain=" + email_domain + ", type=" + type + ", gender=" + gender + ", sign_type="
				+ sign_type + ", reg_date=" + reg_date + "]";
	}

}
