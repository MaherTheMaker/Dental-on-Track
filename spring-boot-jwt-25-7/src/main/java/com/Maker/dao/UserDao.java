package com.Maker.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Maker.model.DAOUser;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	List<DAOUser> findAll();
	DAOUser findById(int id);

	
}