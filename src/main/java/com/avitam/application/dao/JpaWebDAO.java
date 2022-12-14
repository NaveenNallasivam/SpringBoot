package com.avitam.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.avitam.application.model.Jspuser;

public interface JpaWebDAO extends JpaRepository<Jspuser, Integer> {

	public Jspuser findByUserIdAndPassword(int id, String password);

}
