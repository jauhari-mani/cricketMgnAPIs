package com.ptCricket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ptCricket.dao.MatchDao;
import com.ptCricket.models.Matches;

@Service
@Component
public class MatchService {

	@Autowired
	private MatchDao matchRepository;
	
	/**
	 * This Method save match object to the database.
	 * and returns the same object as success.
	 * @param matchObj
	 * @return
	 */
	public Matches save(Matches matchObj) {
		return matchRepository.save(matchObj);
	}
	
	/**
	 * This method fetches all the objects from database and returns in a list.
	 * @return
	 */
	public List<Matches> findAll(){
		return matchRepository.findAll();
	}
	
	/**
	 * This method takes the match id and fetches all the details.
	 * @param id
	 * @return
	 */
	public Matches findById(int id) {
		return matchRepository.findById(id).get();
	}
	
	
}
