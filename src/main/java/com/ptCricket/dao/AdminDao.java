package com.ptCricket.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ptCricket.models.Admin;

@Repository
@Component
public interface AdminDao extends CrudRepository<Admin, String> {

}
