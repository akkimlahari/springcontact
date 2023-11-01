package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.Dao.ContactDao;
import com.demo.entities.Contact;

@Service
public class Serviceimple implements ContactService{
	@Autowired
	private ContactDao cdao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public List<Contact> getContact() {
		
		return cdao.findAll();
	}

	@Override
	public Contact addContact( Contact c) {
		cdao. save(c);
		return c;
				
	}

	@Override
	public Contact updateContact(Contact c) {
		cdao.save(c);
		return c;
	}

	
		
	

	@Override
	public Contact findById(Long id) {
		
		return cdao.findById(id).orElse(null);
	}

	@Override
	public void deleteContact(Long id) {
		Contact entity=cdao.getOne(id);
		cdao.delete(entity);
		
	}

	@Override
	public List<Contact> findByName(String name) {
		List<Contact>c1=cdao.findByName(name);
		c1.forEach(e->System.out.println(e));
		return c1;
		
	}

	

	
	

	

}
