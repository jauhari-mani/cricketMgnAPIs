package com.ptCricket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ptCricket.models.Matches;

@Component
@Repository
public interface MatchDao extends JpaRepository<Matches, Integer>{

}
