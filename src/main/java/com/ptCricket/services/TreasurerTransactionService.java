/**
 * 
 */
package com.ptCricket.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ptCricket.dao.TreasurerTransactionDao;
import com.ptCricket.models.TreasurerTransaction;

/**
 * @author manijauhari
 *
 */
@Service
@Component
public class TreasurerTransactionService {

	private TreasurerTransactionDao treasurerTransactionDao;
	
	public TreasurerTransaction save(TreasurerTransaction treasurerTransactionObj) {
		return this.treasurerTransactionDao.save(treasurerTransactionObj);
	}
	
	public List<TreasurerTransaction> findAll(){
		return this.treasurerTransactionDao.findAll();
	}
}
