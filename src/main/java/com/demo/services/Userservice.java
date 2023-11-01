package com.demo.services;

import com.demo.DTO.LoginDTO;
import com.demo.DTO.UserDTO;
import com.demo.response.LoginResponse.LoginMessage;


public interface Userservice {

	String addUser(UserDTO userDTO);

	LoginMessage loginUser(LoginDTO loginDTO);

	 

}
