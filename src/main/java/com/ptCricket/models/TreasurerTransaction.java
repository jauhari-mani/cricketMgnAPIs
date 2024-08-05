package com.ptCricket.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TreasurerTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private LocalDate dateOfTransaction;
	private String message;
	private String transacrionType;
	
	
	/**
	 * 
	 */
	public TreasurerTransaction() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param dateOfTransaction
	 * @param message
	 * @param transacrionType
	 */
	public TreasurerTransaction(int id, LocalDate dateOfTransaction, String message, String transacrionType) {
		super();
		this.id = id;
		this.dateOfTransaction = dateOfTransaction;
		this.message = message;
		this.transacrionType = transacrionType;
	}


	/**
	 * @return the dateOfTransaction
	 */
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	/**
	 * @param dateOfTransaction the dateOfTransaction to set
	 */
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
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
	 * @return the transacrionType
	 */
	public String getTransacrionType() {
		return transacrionType;
	}
	/**
	 * @param transacrionType the transacrionType to set
	 */
	public void setTransacrionType(String transacrionType) {
		this.transacrionType = transacrionType;
	}
	
	
}
