package com.ptCricket.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	private String uname;
	private String pswrd;
	private Double poolMoney;
	private Double toBeCollected;
	
	
	
	/**
	 * 
	 */
	public Admin() {
		super();
	}
	/**
	 * @param uname
	 * @param pswrd
	 * @param poolMoney
	 * @param toBeCollected
	 */
	public Admin(String uname, String pswrd, Double poolMoney, Double toBeCollected) {
		super();
		this.uname = uname;
		this.pswrd = pswrd;
		this.poolMoney = poolMoney;
		this.toBeCollected = toBeCollected;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPswrd() {
		return pswrd;
	}
	public void setPswrd(String pswrd) {
		this.pswrd = pswrd;
	}
	public Double getPoolMoney() {
		return poolMoney;
	}
	public void setPoolMoney(Double poolMoney) {
		this.poolMoney = poolMoney;
	}
	public Double getToBeCollected() {
		return toBeCollected;
	}
	public void setToBeCollected(Double toBeCollected) {
		this.toBeCollected = toBeCollected;
	}
}
