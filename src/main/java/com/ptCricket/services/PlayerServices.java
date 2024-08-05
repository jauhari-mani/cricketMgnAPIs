package com.ptCricket.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ptCricket.dao.PlayersDao;
import com.ptCricket.models.Players;

@Service
@Component
public class PlayerServices {

	@Autowired
	private PlayersDao playerDao; 
	
	private final String FOLDER_PATH = new File("src/main/resources/playerPhotos").getAbsolutePath();

	
	public List<Players> findAll(){
		return (List<Players>) playerDao.findAll();
	}
	
	public Players findById(int id) {
		return this.playerDao.findById(id).get();
	}
	
	public Players save(String playerDetails, MultipartFile image) {
		Players playersObj = this.stringToPlayerObject(playerDetails);
		if(image != null) {
			if(!playersObj.getProfilePhotoPath().isBlank()) {
				this.deletePlayerImage(playersObj.getProfilePhotoPath());
			}
			String savedImageFilePath = this.saveImage(image, playersObj.getName());
			playersObj.setProfilePhotoPath(savedImageFilePath);			
		}
		return this.playerDao.save(playersObj);
	}
	
	public Players update(String playerDetails, MultipartFile image) {
		Object playerObject = JSONValue.parse(playerDetails);
		JSONObject jsonObj = (JSONObject) playerObject;
		int playerId = Integer.parseInt(String.valueOf(jsonObj.get("id")));
		Players playerObj = this.stringToPlayerObject(playerDetails);
		playerObj.setId(playerId);
		playerObj.setProfilePhotoPath(this.findById(playerId).getProfilePhotoPath());
		if(image != null) {
			if(!playerObj.getProfilePhotoPath().isBlank()) {
				this.deletePlayerImage(playerObj.getProfilePhotoPath());
			}
			String savedImageFilePath = this.saveImage(image, playerObj.getName());
			playerObj.setProfilePhotoPath(savedImageFilePath);			
		}
		return this.playerDao.save(playerObj);
	}
	
	public Players save(Players playerObj) {
		return this.playerDao.save(playerObj);
	}
	
	public byte[] getImage(int id) {
		
		Players playerObj = this.playerDao.findById(id).get();
		String path = playerObj.getProfilePhotoPath();
		if(path == null || path.isBlank()) {
			return null; 
		}
		byte[] images;
		try {
			images = Files.readAllBytes(new File(path).toPath());
			return images;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Players stringToPlayerObject(String playerDetails) {
		Object playerObject = JSONValue.parse(playerDetails);
		JSONObject jsonObj = (JSONObject) playerObject;
		Players playerObj = new Players();
		playerObj.setName((String)jsonObj.get("name"));
		playerObj.setEmail((String) jsonObj.get("email"));
		playerObj.setPhnNumber( String.valueOf(jsonObj.get("phnNumber")));
		playerObj.setWallet(0.00);
		return playerObj;
	}
	
	private String saveImage(MultipartFile image, String playerName) {
		String contentType = image.getContentType();
		int index = contentType.indexOf("/");
		contentType = contentType.substring(index + 1);
		String filePath = this.FOLDER_PATH + "\\" + playerName + "." + contentType;
		try {
			image.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

	private boolean deletePlayerImage(String path) {
		Path imagePath = new File(path).toPath();
		try {
			return Files.deleteIfExists(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
