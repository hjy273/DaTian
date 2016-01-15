package cn.edu.bjtu.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Generated 2015-1-31 22:44:34 by Hibernate Tools 3.4.0.CR1

@Entity
@Table(name="userinfo")
public class Userinfo implements java.io.Serializable {
	@Id
	private String id;
	private String username;
	private String password;
	private String phone;
	private String privilege;
	private int userKind;
	//���ݿ�û������ֶβ�֪���ǲ�������ɾ�ˣ�/// add by iver at 2016��1��15��,����11:45:00 
	/*private String hostAccount;*/
	private String status;
	//���ݿ�û������ֶβ�֪���ǲ�������ɾ��
	/*private String subAccountStatus;*/// add by iver at 2016��1��15��,����11:45:00 
	private String email;
	
	private String phoneStatus;
	private String emailStatus;
	private String securityQuestionStatus;
	
	private String securityQuestionOne;
	private String securityAnswerOne;
	private String securityQuestionTwo;
	private String securityAnswerTwo;
	private String securityQuestionThree;
	private String securityAnswerThree;
	
	private Date validateTime;
	
	private String headIcon;// add by RussWest0 at 2015��6��2��,����11:55:34 
	private String feedback;// add by �Բ�Ԩ
	
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public String getHeadIcon() {
		return headIcon;
	}

	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}

	public Date getValidateTime() {
		return validateTime;
	}

	public void setValidateTime(Date validateTime) {
		this.validateTime = validateTime;
	}

	public Userinfo() {
	}

	public Userinfo(String id) {
		this.id = id;
	}

	

	public String getPhoneStatus() {
		return phoneStatus;
	}

	public void setPhoneStatus(String phoneStatus) {
		this.phoneStatus = phoneStatus;
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getSecurityQuestionStatus() {
		return securityQuestionStatus;
	}

	public void setSecurityQuestionStatus(String securityQuestionStatus) {
		this.securityQuestionStatus = securityQuestionStatus;
	}

	public String getSecurityQuestionOne() {
		return securityQuestionOne;
	}

	public void setSecurityQuestionOne(String securityQuestionOne) {
		this.securityQuestionOne = securityQuestionOne;
	}

	public String getSecurityAnswerOne() {
		return securityAnswerOne;
	}

	public void setSecurityAnswerOne(String securityAnswerOne) {
		this.securityAnswerOne = securityAnswerOne;
	}

	public String getSecurityQuestionTwo() {
		return securityQuestionTwo;
	}

	public void setSecurityQuestionTwo(String securityQuestionTwo) {
		this.securityQuestionTwo = securityQuestionTwo;
	}

	public String getSecurityAnswerTwo() {
		return securityAnswerTwo;
	}

	public void setSecurityAnswerTwo(String securityAnswerTwo) {
		this.securityAnswerTwo = securityAnswerTwo;
	}

	public String getSecurityQuestionThree() {
		return securityQuestionThree;
	}

	public void setSecurityQuestionThree(String securityQuestionThree) {
		this.securityQuestionThree = securityQuestionThree;
	}

	public String getSecurityAnswerThree() {
		return securityAnswerThree;
	}

	public void setSecurityAnswerThree(String securityAnswerThree) {
		this.securityAnswerThree = securityAnswerThree;
	}

	public int getUserKind() {
		return userKind;
	}

	public void setUserKind(int userKind) {
		this.userKind = userKind;
	}

	/*public String getHostAccount() {
		return hostAccount;
	}

	public void setHostAccount(String hostAccount) {
		this.hostAccount = hostAccount;
	}*/

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

/*	public String getSubAccountStatus() {
		return subAccountStatus;
	}

	public void setSubAccountStatus(String subAccountStatus) {
		this.subAccountStatus = subAccountStatus;
	}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

}
