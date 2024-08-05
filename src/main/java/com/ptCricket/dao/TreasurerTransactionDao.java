/**
 * 
 */
package com.ptCricket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ptCricket.models.TreasurerTransaction;

/**
 * @author manijauhari
 *
 */
@Repository
@Component
public interface TreasurerTransactionDao extends JpaRepository<TreasurerTransaction, Integer>{

}
