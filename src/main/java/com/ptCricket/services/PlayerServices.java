package com.ptCricket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ptCricket.dao.PlayersDao;
import com.ptCricket.models.Players;

@Service
@Component
public class PlayerServices {

	@Autowired
	private PlayersDao playerDao; 

	
	public List<Players> findAll(){
		return (List<Players>) playerDao.findAll();
	}
	
	public Players save(Players objPlayers) {
		return playerDao.save(objPlayers);
	}
	
	public Players findById(int id) {
		return this.playerDao.findById(id).get();
	}
}
