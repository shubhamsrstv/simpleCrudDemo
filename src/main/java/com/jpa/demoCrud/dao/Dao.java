package com.jpa.demoCrud.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpa.demoCrud.beans.Profile;

public interface Dao extends CrudRepository<Profile, Integer>{

	@Query("select u from Profile u where u.name = ?1")
	Profile findByName(String name);
}
