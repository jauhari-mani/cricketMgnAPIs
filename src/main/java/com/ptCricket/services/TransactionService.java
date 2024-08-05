/**
 * 
 */
package com.ptCricket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ptCricket.dao.PlayersDao;
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
	
	@Autowired
	private PlayersDao playerRepository;

	public Transactions save(Transactions objTransactions) {
		Players objPlayer = this.playerRepository.findById(objTransactions.getPlayer().getId()).get();
		if(objTransactions.getTransactionType().equalsIgnoreCase("Credit")) {
			objPlayer.setWallet(objPlayer.getWallet() + objTransactions.getAmount());
		}
		else {
			objPlayer.setWallet(objPlayer.getWallet() - objTransactions.getAmount());
		}
		this.playerRepository.save(objPlayer);
		return this.transactionRepository.save(objTransactions);
	}
	
	public List<Transactions> findAll(){
		return this.transactionRepository.findAll();
	}
	
	public List<Transactions> findAllByPlayer(Players players){
		return this.transactionRepository.findByPlayer(players);
	}
}
