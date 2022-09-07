package com.ptCricket.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Players {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String phnNumber;
	private String email;
	private Double wallet;
	private byte[] playerPhoto;
	
	public Players() {
		super();
	}
	public Players(String name, String phnNumber, String email, Double wallet, byte[] playerPhoto) {
		super();
		this.name = name;
		this.phnNumber = phnNumber;
		this.email = email;
		this.wallet = wallet;
		this.playerPhoto = playerPhoto;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhnNumber() {
		return phnNumber;
	}
	public void setPhnNumber(String phnNumber) {
		this.phnNumber = phnNumber;
	}
	public Double getWallet() {
		return wallet;
	}
	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}
	public byte[] getPlayerPhoto() {
		return playerPhoto;
	}
	public void setPlayerPhoto(byte[] playerPhoto) {
		this.playerPhoto = playerPhoto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
