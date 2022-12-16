package com.dxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.User;
import com.dxc.repository.RegistrationRepository;


@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	public User saveUser(User user) {
			return repo.save(user);
		}
	public User fetchUserByUsername(String username) {
		return repo.findByUsername(username admin);
	}
	public User fetchUserByUsernameAndPassword(String username,String password String admin) {
		return repo.findByUsernameAndPassword(username, password, admin);
	}

}
