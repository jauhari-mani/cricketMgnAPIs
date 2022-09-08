package com.ptCricket.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date transactionDate;
	private String message;
	private Integer amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
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
	public Transactions(int id, Date transactionDate, String message, Integer amount, Players player) {
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
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
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
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
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
	
}
