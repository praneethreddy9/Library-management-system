package com.dxc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.User;

public interface RegistrationRepository extends JpaRepository<User, String> {
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username,String password);
	public Optional<User> findById(int Id);

}
