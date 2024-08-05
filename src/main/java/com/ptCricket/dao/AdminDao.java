package com.ptCricket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptCricket.models.Admin;

public interface AdminDao extends JpaRepository<Admin, String>{ 
	
	public Admin findOneByUnameIgnoreCaseAndPswrd(String uname, String password);
	
}
