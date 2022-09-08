/**
 * 
 */
package com.ptCricket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptCricket.models.Admin;
import com.ptCricket.services.AdminService;

/**
 * @author manijauhari
 *
 */
@RequestMapping("/admin")
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping
	public Admin save(@RequestBody Admin adminObj) {
		return this.adminService.save(adminObj);
	}
	
	@GetMapping
	public List<Admin> findAll(){
		return this.adminService.findAll();
	}
	
	@GetMapping("/{uname}")
	public Admin findById(@PathVariable String uname) {
		return this.adminService.findById(uname);
	}
	
}
