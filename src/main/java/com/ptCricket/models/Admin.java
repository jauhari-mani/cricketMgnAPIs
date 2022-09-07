package com.ptCricket.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	private String uname;
	private String name;
	private String pswrd;
	private String emailId;
	private Double pollMoney;
	
	public Admin() {
		super();
	}
	public Admin(String uname, String name, String pswrd, String emailId, Double pollMoney) {
		super();
		this.uname = uname;
		this.name = name;
		this.pswrd = pswrd;
		this.emailId = emailId;
		this.pollMoney = pollMoney;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPswrd() {
		return pswrd;
	}
	public void setPswrd(String pswrd) {
		this.pswrd = pswrd;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Double getPollMoney() {
		return pollMoney;
	}
	public void setPollMoney(Double pollMoney) {
		this.pollMoney = pollMoney;
	}
	
	

	
}
