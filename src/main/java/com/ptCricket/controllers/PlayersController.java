/**
 * 
 */
package com.ptCricket.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptCricket.models.Matches;
import com.ptCricket.models.Players;
import com.ptCricket.services.PlayerServices;

/**
 * @author manijauhari
 *
 */
@RestController
@RequestMapping("/players")
public class PlayersController {

	@Autowired
	private PlayerServices playerServices;

	@PostMapping()
	public Players save(@RequestBody Players objPlayer) {
		return this.playerServices.save(objPlayer);
	}
	
	@GetMapping("/matches/{id}")
	public Set<Matches> findAllMatches(@PathVariable int id){
		Players playerObj = this.playerServices.findById(id);
		return playerObj.getMatches();
	}
	
	@GetMapping()
	public List<Players> findAll(){
		return this.playerServices.findAll();
	}
	
	@GetMapping("/{id}")
	public Players findById(@PathVariable int id) {
		return this.playerServices.findById(id);
	}
}
