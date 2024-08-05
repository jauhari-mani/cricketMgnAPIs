package com.ptCricket.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private LocalDate transactionDate;
	private String message;
	private Double amount;
	private String transactionType;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "player_Id", referencedColumnName = "id")
	private Players player;

	/**
	 * 
	 */
	public Transactions() {
		super();
	}

	/**
	 * @param id
	 * @param transactionDate
	 * @param message
	 * @param amount
	 * @param player
	 */
	public Transactions(int id, LocalDate transactionDate, String message, Double amount, Players player) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.message = message;
		this.amount = amount;
		this.player = player;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the transactionDate
	 */
	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the playerId
	 */
	public Players getPlayer() {
		return player;
	}

	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayer(Players playerId) {
		this.player = playerId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", transactionDate=" + transactionDate + ", message=" + message + ", amount="
				+ amount + ", transactionType=" + transactionType + ", player=" + player.getId() + "]";
	}
	
	
}
