/**
 * 
 */
package com.ptCricket.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.ptCricket.dto.ImagesInfo;
import com.ptCricket.dto.ResponseMessage;
import com.ptCricket.models.Admin;
import com.ptCricket.services.AdminService;

/**
 * @author manijauhari
 *
 */
@RequestMapping("/admin")
@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping
	public Admin getBalance(@RequestParam(value = "uname") String uname ) {
		return this.adminService.findByUname(uname);
	}
	
	@PostMapping("/image")
	public boolean saveImage(@RequestParam(value = "image") MultipartFile image){
		return this.adminService.saveImage(image);
	}
	
	@GetMapping("/images")
	  public ResponseEntity<List<ImagesInfo>> getListFiles() {
		List<ImagesInfo> fileInfos = this.adminService.loadAll().map(path -> {
		      String filename = path.getFileName().toString();
		      String url = MvcUriComponentsBuilder
		          .fromMethodName(AdminController.class, "getFile", path.getFileName().toString()).build().toString();

		      return new ImagesInfo(filename, url);
		    }).collect(Collectors.toList());

		    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }
	@GetMapping("/image/{filename:.+}")
	@ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = this.adminService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }
	
	@DeleteMapping("/image/{filename:.+}")
	  public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String filename) {
	    String message = "";
	    
	    try {
	      boolean existed = this.adminService.delete(filename);
	      
	      if (existed) {
	        message = "Delete the file successfully: " + filename;
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      }
	      
	      message = "The file does not exist!";
	      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not delete the file: " + filename + ". Error: " + e.getMessage();
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(message));
	    }
	  }
}
