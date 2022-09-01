package db.entities;

import db.entities.Entity;

/**
 * Provide records for virtual table:
 * 
 * <pre>
 * |user.id|user.login|user.password|userInfo.firstName|userInfo.lastName|          
 * |userInfo.passportNumber|userInfo.phoneNumber|userInfo.email|user.status|
 * </pre>
 * 
 * @author A.Yegorov
 *
 */

public class UserInfoBean extends Entity {

	private static final long serialVersionUID = 2699807869303394136L;

	private int userId;

	private String login;

	private String password;

	private String firstName;

	private String lastName;

	private String passportNumber;

	private String phoneNumber;

	private String email;

	private boolean status;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserInfoBean [userId=" + userId + ", login=" + login
				+ ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", passportNumber="
				+ passportNumber + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", status=" + status + "]";
	}

}
