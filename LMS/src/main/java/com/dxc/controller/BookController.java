package com.dxc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Books;
import com.dxc.repository.BookRepository;



@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class BookController {

	@Autowired
	 private BookRepository bookRepository;
	
	
	@GetMapping("/books")
	public List<Books> getAllbooks()
	{
				 return (List<Books>) bookRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getStudentById(@PathVariable(value = "id") int bookId)
	        throws ResourceNotFoundException {
	        Books book = bookRepository.findById(bookId)
	          .orElseThrow(() -> new ResourceNotFoundException("book not found for this id :: " + bookId));
	        return ResponseEntity.ok().body(book);
	    }
	@PostMapping("/books")
	public Books createbook ( @RequestBody Books book)
	{
		return bookRepository.save(book);
	}
	
	@PutMapping("/books/{id}")
	 public ResponseEntity<Books> updatebook(@PathVariable(value = "id") int bookId,
	          @RequestBody Books bookDetails) throws ResourceNotFoundException {
	        Books book = bookRepository.findById(bookId)
	        .orElseThrow(() -> new ResourceNotFoundException("book not found for this id :: " + bookId));

	        book.setRackno(bookDetails.getRackno());
	        book.setName(bookDetails.getName());
	        book.setBookid(bookDetails.getBookid());
	        book.setAuthor(bookDetails.getAuthor());
	        book.setCategory(bookDetails.getCategory());
	        book.setPrice(bookDetails.getPrice());
	        book.setStatus(bookDetails.getStatus());
	        
	        final Books updatedbook = bookRepository.save(book);
	        return ResponseEntity.ok(updatedbook);
	    }

	
	@DeleteMapping(  "/books/{id}")
	public Map<String, Boolean> deletebook(@PathVariable(value = "id") int bookId)
	         throws ResourceNotFoundException {
	        Books book = bookRepository.findById(bookId)
	       .orElseThrow(() -> new ResourceNotFoundException("book not found for this id :: " + bookId));

	        bookRepository.delete(book);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
	
	}
