package com.ptCricket.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ptCricket.dao.AdminDao;
import com.ptCricket.models.Admin;

@Service
@Component
public class AdminService {

	@Autowired
	private AdminDao adminDao;


	public Admin save(Admin objAdmin) {
		return adminDao.save(objAdmin);
	}
	
	public Admin findById(String uname) {
		Optional<Admin> user = adminDao.findById(uname);
		return user.get();
	}
}
