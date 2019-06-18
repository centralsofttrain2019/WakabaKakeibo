package dto;

import java.time.LocalDate;
import domain.UserSexEnum;

import domain.UserSexEnum;

public class UsersDto
{
	private int userID;
	private String password;
	private String userName;
	private UserSexEnum sex;
	private LocalDate birthday;
	private int targetAmount;
	private int presentAmount;
	private LocalDate lastLogin;
	private int runningDays;
	private int feelingLevel;
	private String honorific;


	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserSexEnum getSex() {
		return sex;
	}
	public void setSex(UserSexEnum sex) {
		this.sex = sex;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public int getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}
	public int getPresentAmount() {
		return presentAmount;
	}
	public void setPresentAmount(int presentAmount) {
		this.presentAmount = presentAmount;
	}
	public LocalDate getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}
	public int getRunningDays() {
		return runningDays;
	}
	public void setRunningDays(int runningDays) {
		this.runningDays = runningDays;
	}
	public int getFeelingLevel() {
		return feelingLevel;
	}
	public void setFeelingLevel(int feelingLevel) {
		this.feelingLevel = feelingLevel;
	}
	public String getHonorific() {
		return honorific;
	}
	public void setHonorific(String honorific) {
		this.honorific = honorific;
	}
	@Override
	public String toString() {
		return "UsersDto [userID=" + userID + ", password=" + password + ", userName=" + userName + ", sex=" + sex
				+ ", birthday=" + birthday + ", targetAmount=" + targetAmount + ", presentAmount=" + presentAmount
				+ ", lastLogin=" + lastLogin + ", runningDays=" + runningDays + ", feelingLevel=" + feelingLevel
				+ ", honorific=" + honorific + "]";
	}


}
