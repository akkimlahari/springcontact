package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.entities.Contact;


public interface ContactService {

public List<Contact> getContact();



public Contact updateContact(Contact c);




public Contact addContact(Contact c);



public Contact findById(Long id);



public void deleteContact(Long id);



public List<Contact> findByName(String name);




	

}
