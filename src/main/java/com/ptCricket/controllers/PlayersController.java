/**
 * 
 */
package com.ptCricket.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ptCricket.models.Matches;
import com.ptCricket.models.Players;
import com.ptCricket.services.PlayerServices;

/**
 * @author manijauhari
 *
 */
@RestController
@RequestMapping("/players")
@CrossOrigin("*")
public class PlayersController {

	@Autowired
	private PlayerServices playerServices;

	@PostMapping()
	public Players save(@RequestParam(value = "image")MultipartFile image, @RequestParam(value = "player") String playerDetails) {
		return this.playerServices.save(playerDetails, image);
	}
	
	/**
	 * Method to fetch players image.
	 * @param path
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/image")
	public ResponseEntity<?> getImage(@RequestParam(value = "id") int id) throws IOException {
		byte[] images = playerServices.getImage(id);
		if(images == null) {
			return ResponseEntity.status(HttpStatus.OK).body("File doesn't exits");			
		}
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.parseMediaType("image/jpeg"))
				.body(images);
	}
	
	@PutMapping
	public Players updatePlayer(@RequestParam(value = "player") String playerDetails , @RequestParam(value = "image", required = false)MultipartFile image) {
		return this.playerServices.update(playerDetails, image);
	}
	
	/**
	 * Method to fetch all the matches player played.
	 * @param id
	 * @return
	 */
	@GetMapping("/matches/{id}")
	public Set<Matches> findAllMatches(@PathVariable int id){
		Players playerObj = this.playerServices.findById(id);
		return playerObj.getMatches();
	}
	
	/**
	 * Fetch all the player records.
	 * @return
	 */
	@GetMapping()
	public List<Players> findAll(){
		return this.playerServices.findAll();
	}
	
	/**
	 * Fetch player record as per their id.
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Players findById(@PathVariable int id) {
		return this.playerServices.findById(id);
	}
	
	/**
	 * Method to fetch all the Matches in which player took his/her car.
	 * @param id
	 * @return
	 */
	@GetMapping("/car/{id}")
	public Set<Matches> findAllMatchesWithCar(@PathVariable int id){
		Players playerObj = this.playerServices.findById(id);
		return playerObj.getCarInMatch();
	}
}
