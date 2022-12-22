package com.avitam.application.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.avitam.application.model.Jspuser;

public interface JpaWebDAO extends JpaRepository<Jspuser, Integer> {

	public Jspuser findByUserIdAndPassword(int id, String password);
	
	
}
