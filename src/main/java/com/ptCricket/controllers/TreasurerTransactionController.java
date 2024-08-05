package com.ptCricket.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptCricket.models.TreasurerTransaction;
import com.ptCricket.services.TreasurerTransactionService;

/**
 * This controller is for treasurer transaction records.
 * there are two methods :
 * 1. Post Mapping for saving the transaction into the database;
 * 2. Get Mapping to fetch all the treasurer records from database; 
 * @author manijauhari
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/treasurer/transactions")
public class TreasurerTransactionController {
	
	private TreasurerTransactionService service;
	
	@PostMapping
	public TreasurerTransaction save(@RequestBody TreasurerTransaction transactionObj) {
		return this.service.save(transactionObj);
	}
	
	@GetMapping
	public List<TreasurerTransaction> findAll() {
		return this.service.findAll();
	}
}
