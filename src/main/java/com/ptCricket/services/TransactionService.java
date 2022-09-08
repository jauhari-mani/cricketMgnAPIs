/**
 * 
 */
package com.ptCricket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ptCricket.dao.TransactionDao;
import com.ptCricket.models.Players;
import com.ptCricket.models.Transactions;

/**
 * @author manijauhari
 *
 */
@Service
@Component
public class TransactionService {
	
	@Autowired
	private TransactionDao transactionRepository;

	public Transactions save(Transactions objTransactions) {
		return this.transactionRepository.save(objTransactions);
	}
	
	public List<Transactions> findAll(){
		return this.transactionRepository.findAll();
	}
	
	public List<Transactions> findAllByPlayer(Players players){
		return this.transactionRepository.findByPlayer(players);
	}
}
