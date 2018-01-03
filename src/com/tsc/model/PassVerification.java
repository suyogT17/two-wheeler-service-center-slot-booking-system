package com.tsc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PassVerification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer verificationCodeId;
	
	@Column
	private String verificationCode;
	
	@Column
	private String Username;
	
	@Column
	private String Password;

	public Integer getVerificationCodeId() {
		return verificationCodeId;
	}

	public void setVerificationCodeId(Integer verificationCodeId) {
		this.verificationCodeId = verificationCodeId;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	
}
