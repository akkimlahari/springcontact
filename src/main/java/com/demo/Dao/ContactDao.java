package com.demo.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Contact;
;

public interface ContactDao extends JpaRepository<Contact,Long>{
	
	public List<Contact> findByName(String name);

	
	
}
