package com.revshop.Entity;

public class LoginEntity implements Entity {

	private int loginId;
	private int userId;
	private String userName;
	private String email;
	private String password;
	private boolean isFirstLogin;
	private String role;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFirstLogin() {
		return isFirstLogin;
	}

	public void setFirstLogin(boolean isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LoginEntity() {
		super();
	}

	public LoginEntity(int loginId, int userId, String userName, String email, String password,
			boolean isFirstLogin, String role) {
		super();
		this.loginId = loginId;
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.isFirstLogin = isFirstLogin;
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegistrationDTO [loginId=" + loginId + ", userId=" + userId + ", userName=" + userName + ", email="
				+ email + ", password=" + password + ", isFirstLogin=" + isFirstLogin + ", role=" + role + "]";
	}

}
