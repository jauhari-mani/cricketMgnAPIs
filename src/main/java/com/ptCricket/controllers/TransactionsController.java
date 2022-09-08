package com.ptCricket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptCricket.models.Players;
import com.ptCricket.models.Transactions;
import com.ptCricket.services.PlayerServices;
import com.ptCricket.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private PlayerServices playerServices;

	@PostMapping
	public Transactions save(@RequestBody Transactions objTransactions) {
		return this.transactionService.save(objTransactions);
	}
	
	@GetMapping
	public List<Transactions> findAll(){
		return this.transactionService.findAll();
	}
	
	@GetMapping("/{id}")
	public List<Transactions> findByPlayer(@PathVariable int playerId){
		Players objPlayers = this.playerServices.findById(playerId);
		return this.transactionService.findAllByPlayer(objPlayers);
	}
}
