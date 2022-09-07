package com.ptCricket.models;

public class Players {
	
	private String name;
	private String phnNumber;
	private Double wallet;
	private byte[] playerPhoto;
	
	public Players() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Players(String name, String phnNumber, Double wallet, byte[] playerPhoto) {
		super();
		this.name = name;
		this.phnNumber = phnNumber;
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
}
