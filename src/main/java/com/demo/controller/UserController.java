package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.DTO.LoginDTO;
import com.demo.DTO.UserDTO;
import com.demo.response.LoginResponse.LoginMessage;
import com.demo.services.Userservice;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
	
	@Autowired
	private Userservice userservice;
	
	
	 @PostMapping( "/contacts/save")
	    public String saveUser(@RequestBody UserDTO userDTO)
	    {
	        String id = userservice.addUser(userDTO);
	        return id;

}
	 
	 @PostMapping("/contacts/login")
	 public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
	    {
	        LoginMessage loginmessage = userservice.loginUser(loginDTO);
	        return ResponseEntity.ok(loginmessage);
	    }
}
