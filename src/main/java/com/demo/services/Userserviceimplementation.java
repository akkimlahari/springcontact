package com.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.DTO.LoginDTO;
import com.demo.DTO.UserDTO;
import com.demo.Dao.UserRepo;
import com.demo.entities.User;
import com.demo.response.LoginResponse.LoginMessage;

@Service
public class Userserviceimplementation  implements Userservice{

	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addUser(UserDTO userDTO) {
		User user= new User(
				  userDTO.getId(),
				  userDTO.getUsername(),
		             userDTO.getEmail(),
		             this.passwordEncoder.encode(userDTO.getPassword())
				);
				userrepo.save(user);
				return user.getUsername();
				
				
				
		
		
	}
	UserDTO userDTO;

	@Override
	public LoginMessage loginUser(LoginDTO loginDTO) {
		String msg = "";
	        User user1 = userrepo.findByEmail(loginDTO.getEmail());
	        if (user1 != null) {
	            String password = loginDTO.getPassword();
	            String encodedPassword = user1.getPassword();
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	            if (isPwdRight) {
	                Optional<User> employee = userrepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
	                if (employee.isPresent()) {
	                    return new LoginMessage("Login Success", true);
	                } else {
	                    return new LoginMessage("Login Failed", false);
	                }
	            } else {
	                return new LoginMessage("password Not Match", false);
	            }
	        }else {
	            return new LoginMessage("Email not exits", false);
	        }

		
	}

}
