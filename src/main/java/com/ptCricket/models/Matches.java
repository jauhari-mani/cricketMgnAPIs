package com.ptCricket.models;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity 
public class Matches {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int matchId;
	private LocalDate dateOfMatch;
	private double price;
	private double totalFees;
	private double carCompensation;
	private String playGround;
	private double perPersonContribution;
	
	/**
	 * @return the matchId
	 */
	public int getMatchId() {
		return matchId;
	}

	@ManyToMany
	@JoinTable(
			name = "players_played",
			joinColumns = @JoinColumn(name = "match_Id"),
			inverseJoinColumns = @JoinColumn(name = "player_Id")
			)
	private Set<Players> playersPlayed = new HashSet<Players>();
	
	@ManyToMany
	@JoinTable(
			name = "car_in_matches",
			joinColumns = @JoinColumn(name = "match_Id"),
			inverseJoinColumns = @JoinColumn(name = "player_Id")
			)
	private Set<Players> playersWhoTookTheirCar = new HashSet<>();
	
	
	/**
	 * 
	 */
	public Matches() {
		super();
	}
	/**
	 * @param dateOfMatch
	 * @param price
	 * @param listOfPLayers
	 * @param totalFees
	 * @param carCompensation
	 * @param playGround
	 * @throws ParseException 
	 */
	public Matches(LocalDate dateOfMatch, double price, Double totalFees, Double carCompensation,
			String playGround) throws ParseException {
		super();
		this.dateOfMatch = dateOfMatch;
		this.price = price;
		this.totalFees = totalFees;
		this.carCompensation = carCompensation;
		this.playGround = playGround;
		this.perPersonContribution = this.totalFees;
	}
	/**
	 * @return the dateOfMatch
	 */
	public LocalDate getDateOfMatch() {
		return dateOfMatch;
	}
	/**
	 * @param dateOfMatch the dateOfMatch to set
	 * @throws ParseException 
	 */
	public void setDateOfMatch(LocalDate dateOfMatch) throws ParseException {
		this.dateOfMatch = dateOfMatch;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the totalFees
	 */
	public Double getTotalFees() {
		return totalFees;
	}
	/**
	 * @param totalFees the totalFees to set
	 */
	public void setTotalFees(Double totalFees) {
		this.totalFees = totalFees;
	}
	/**
	 * @return the carCompensation
	 */
	public Double getCarCompensation() {
		return carCompensation;
	}
	/**
	 * @param carCompensation the carCompensation to set
	 */
	public void setCarCompensation(Double carCompensation) {
		this.carCompensation = carCompensation;
	}
	/**
	 * @return the playGround
	 */
	public String getPlayGround() {
		return playGround;
	}
	/**
	 * @param playGround the playGround to set
	 */
	public void setPlayGround(String playGround) {
		this.playGround = playGround;
	}
	/**
	 * @return the perPersonContribution
	 */
	public Double getPerPersonContribution() {
		return perPersonContribution;
	}
	/**
	 * @return the playersPlayed
	 */
	public Set<Players> getPlayersPlayed() {
		return playersPlayed;
	}
	/**
	 * @return the playersWhoTookTheirCar
	 */
	public Set<Players> getPlayersWhoTookTheirCar() {
		return playersWhoTookTheirCar;
	}
	
	public void addPlayer(Players playerObj) {
		this.playersPlayed.add(playerObj);
	}
	
	public void addPlayerCar(Players playerObj) {
		this.playersWhoTookTheirCar.add(playerObj);
	}
	
}
