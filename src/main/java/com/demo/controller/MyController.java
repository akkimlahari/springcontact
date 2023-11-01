package com.demo.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.demo.entities.Contact;

import com.demo.services.ContactService;






@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {
	
	@Autowired
	private ContactService csservice;
	
	
	
	@GetMapping("/contacts")                 //get all contacts
	public List<Contact> getContact(){
		return this.csservice.getContact();
		
	}
	
	@PostMapping("/contacts")                     //add contacts
	public Contact addContact(@RequestBody Contact c){
		
		
		return this.csservice.addContact(c);
		
	}
	// get employee by id rest            //view contacts by id
		@GetMapping("/contacts/{id}")
		public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
			Contact contact =  csservice.findById(id);
			if(contact==null) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.ok(contact);
		}
	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contact>updateContact(@PathVariable Long id,@RequestBody Contact updateContact){
		Contact c=csservice.findById(id);
		if(c==null) {
			return ResponseEntity.notFound().build();
		}
	       c.setName(updateContact.getName());
	       c.setMobile(updateContact.getMobile());
	       c.setEmail(updateContact.getEmail());
	       c.setCity(updateContact.getCity());
	       c.setCompany(updateContact.getCompany());
	       c.setTitle(updateContact.getTitle());
	      
	       Contact savedContact=csservice.updateContact(c);
	       return ResponseEntity.ok(savedContact);
	}
	
	
	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<HttpStatus>deleteCourse(@PathVariable String id)
	{
		try {
	 this.csservice.deleteContact(Long.parseLong(id));
	 return new ResponseEntity<>(HttpStatus.OK);
	}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		@GetMapping("/contacts/name/{name}")
		public List<Contact>findByName(@PathVariable String name){
			return this.csservice.findByName(name);
		}
		
		
		
		 
		 
	
}
	
	
	
	
	
		
		
		
	
	
	
	


