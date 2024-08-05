/**
 * 
 */
package com.ptCricket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptCricket.models.Matches;
import com.ptCricket.models.Players;
import com.ptCricket.models.Transactions;
import com.ptCricket.services.MatchService;
import com.ptCricket.services.PlayerServices;
import com.ptCricket.services.TransactionService;

/**
 * @author manijauhari
 *
 */
@RestController
@RequestMapping("/match")
@CrossOrigin("*")
public class MatchController {

	@Autowired
	private MatchService matchService;
	
	@Autowired
	private PlayerServices playerServices;
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public Matches save(@RequestBody Matches matchObj) {
		for(Players player : matchObj.getPlayersPlayed()) {
			Transactions objTransaction = new Transactions();
			objTransaction.setTransactionDate(matchObj.getDateOfMatch());
			objTransaction.setAmount(matchObj.getPerPersonContribution());
			objTransaction.setMessage("Match of " + matchObj.getDateOfMatch() + " at ground " + matchObj.getPlayGround());
			objTransaction.setTransactionType("Debit");
			objTransaction.setPlayer(player);
			transactionService.save(objTransaction);
			player.setWallet(player.getWallet() - matchObj.getPerPersonContribution());
			playerServices.save(player);
		}
		
		//Setting Car Compensation
		for(Players player : matchObj.getPlayersWhoTookTheirCar()) {
			Transactions objTransaction = new Transactions();
			objTransaction.setTransactionDate(matchObj.getDateOfMatch());
			objTransaction.setAmount(matchObj.getCarCompensation());
			objTransaction.setMessage("Car Compensation for " + matchObj.getDateOfMatch() + " match at ground " + matchObj.getPlayGround());
			objTransaction.setTransactionType("Credit");
			objTransaction.setPlayer(player);
			transactionService.save(objTransaction);
			player.setWallet(player.getWallet() + matchObj.getCarCompensation());
			playerServices.save(player);
		}
		return this.matchService.save(matchObj);
	}
	
	@GetMapping
	public List<Matches> findAll(){
		return this.matchService.findAll();
	}
	
	@GetMapping("/{id}")
	public Matches findById(@PathVariable int id) {
		return this.matchService.findById(id);
	}

	@PutMapping("/{matchId}/player/{playerId}")
	public Matches addPlayer(@PathVariable int matchId, @PathVariable int playerId) {
		Matches matchObj = this.matchService.findById(matchId);
		Players playerObj = this.playerServices.findById(playerId);
		matchObj.addPlayer(playerObj);
		return this.matchService.save(matchObj);
	}
	
	@PutMapping("/{matchId}/cars/{playerId}")
	public Matches addPlayerCar(@PathVariable int matchId, @PathVariable int playerId) {
		Matches matchObj = this.matchService.findById(matchId);
		Players playerObj = this.playerServices.findById(playerId);
		matchObj.addPlayerCar(playerObj);
		return this.matchService.save(matchObj);
	}
}
