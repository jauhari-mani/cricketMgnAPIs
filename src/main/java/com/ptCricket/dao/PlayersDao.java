/**
 * 
 */
package com.ptCricket.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ptCricket.models.Players;

/**
 * @author manijauhari
 *
 */
@Repository
@Component
public interface PlayersDao extends CrudRepository<Players , Integer> {

}
