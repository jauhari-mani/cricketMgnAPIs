package com.ptCricket.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Players {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String phnNumber;
	private String email;
	private Double wallet;
	@Lob
	private byte[] playerPhoto;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "playersPlayed")
	private Set<Matches> matches = new HashSet<Matches>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "playersWhoTookTheirCar")
	private Set<Matches> carInMatch = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "player")
	private Set<Transactions> transactions = new HashSet<>();
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the transactions
	 */
	public Set<Transactions> getTransactions() {
		return transactions;
	}
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
	/**
	 * @return the matches
	 */
	public Set<Matches> getMatches() {
		return matches;
	}
	/**
	 * @return the carInMatch
	 */
	public Set<Matches> getCarInMatch() {
		return carInMatch;
	}
}
