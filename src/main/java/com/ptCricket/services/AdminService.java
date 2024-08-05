package com.ptCricket.services;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ptCricket.dao.AdminDao;
import com.ptCricket.models.Admin;

@Service
@Component
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	private final String FILE_PATH = new File("src/main/resources/HomePagePhotos").getAbsolutePath();
	
	public Admin find(String uname, String password) {
		return this.adminDao.findOneByUnameIgnoreCaseAndPswrd(uname, password);
	}
	
	public Admin findByUname(String Uname) {
		return this.adminDao.findById(Uname).get();
	}
	
	public boolean saveImage(MultipartFile image){
		if(image != null) {			
			String path = this.FILE_PATH + "/" + image.getOriginalFilename();
			try {
				image.transferTo(new File(path));
				return true;
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	 public Resource load(String filename) {
	    try {
	      Path file = new File(this.FILE_PATH).toPath().resolve(filename);
	      Resource resource = new UrlResource(file.toUri());
	
	      if ( resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("Could not read the file!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	 }
	 
	 public Stream<Path> loadAll() {
		Path root = new File(this.FILE_PATH).toPath();
		try {
		  return Files.walk(root, 1).filter(path -> !path.equals(root)).map(root::relativize);
		} catch (IOException e) {
		  throw new RuntimeException("Could not load the files!");
		}
	 }
	
	 public boolean delete(String filename) {
		 Path root = new File(this.FILE_PATH).toPath();  
		 try {
		      Path file = root.resolve(filename);
		      return Files.deleteIfExists(file);
		    } catch (IOException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
		  }
}
