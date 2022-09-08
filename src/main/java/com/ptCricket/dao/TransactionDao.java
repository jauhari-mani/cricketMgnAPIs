package com.ptCricket.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ptCricket.models.Players;
import com.ptCricket.models.Transactions;

@Repository
@Component
public interface TransactionDao extends JpaRepository<Transactions, Integer>{

	List<Transactions> findByPlayer(Players players);

}
