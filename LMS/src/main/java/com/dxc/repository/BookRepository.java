package com.dxc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.dxc.model.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {
	
	  

}
