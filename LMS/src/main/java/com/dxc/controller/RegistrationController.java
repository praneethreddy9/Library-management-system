package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.User;
import com.dxc.service.RegistrationService;

@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
   @PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
	   String tempUsername = user.getUsername();
	   if(tempUsername != null && !"".equals(tempUsername)) {
		 User userobj =  service.fetchUserByUsername(tempUsername);
		 if(userobj != null) {
			 throw new Exception("user with "+tempUsername+" is aready exist");
		 }
	   }
		User userObj = null;
		userObj = service.saveUser(user);		
		return userObj;
	}
   @PostMapping("/login")
   public User loginUser(@RequestBody User user) throws Exception {
	  String tempUsername = user.getUsername();
	   String tempPass = user.getPassword();
       User userObj = null; 
			   if(tempUsername != null && tempPass != null) {
			userObj = service.fetchUserByUsernameAndPassword(tempUsername, tempPass);
			   }
			   if(userObj == null) {
				   throw new Exception("bad credentials");
			   }
	   return userObj;
   }
 
}