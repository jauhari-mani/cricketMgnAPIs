package com.ptCricket.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Players {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	@Column(unique = true)
	private String phnNumber;
	@Column(unique = true)
	private String email;
	private Double wallet;
	private String profilePhotoPath;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "playersPlayed")
	private Set<Matches> matches = new HashSet<Matches>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "playersWhoTookTheirCar")
	private Set<Matches> carInMatch = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "player", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<Transactions> transactions = new HashSet<>();
	
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
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
	
	/**
	 * @param id
	 * @param name
	 * @param phnNumber
	 * @param email
	 * @param wallet
	 * @param profilePhotoPath
	 * @param matches
	 * @param carInMatch
	 * @param transactions
	 */
	public Players(int id, String name, String phnNumber, String email, Double wallet, String profilePhotoPath,
			Set<Matches> matches, Set<Matches> carInMatch, Set<Transactions> transactions) {
		super();
		this.id = id;
		this.name = name;
		this.phnNumber = phnNumber;
		this.email = email;
		this.wallet = wallet;
		this.profilePhotoPath = profilePhotoPath;
		this.matches = matches;
		this.carInMatch = carInMatch;
		this.transactions = transactions;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * @return the profilePhotoPath
	 */
	public String getProfilePhotoPath() {
		return profilePhotoPath;
	}
	/**
	 * @param profilePhotoPath the profilePhotoPath to set
	 */
	public void setProfilePhotoPath(String profilePhotoPath) {
		this.profilePhotoPath = profilePhotoPath;
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
