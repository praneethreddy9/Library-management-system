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

import com.dxc.model.Magazines;
import com.dxc.repository.MagazineRepository;




@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class MagazinesController {

	@Autowired
	 private MagazineRepository magazineRepository;
	
	
	@GetMapping("/magazines")
	public List<Magazines> getAllmagazines()
	{
				 return (List<Magazines>) magazineRepository.findAll();
	}
	
	@GetMapping("/magazines/{name}")
	public ResponseEntity<Magazines> getMagazinesByName(@PathVariable(value = "name") String magazinename)
	        throws ResourceNotFoundException {
	        Magazines magazines = magazineRepository.findByName(magazinename)
	          .orElseThrow(() -> new ResourceNotFoundException("magazine not found for this name :: " + magazinename));
	        return ResponseEntity.ok().body(magazines);
	    }
	@PostMapping("/magazines")
	public Magazines createmagazines( @RequestBody Magazines magazines)
	{
		return magazineRepository.save(magazines);
	}
	
	@PutMapping("/magazines/{name}")
	 public ResponseEntity<Magazines> updatemagazines(@PathVariable(value = "name") String magazinesname,
	          @RequestBody Magazines magazinesDetails) throws ResourceNotFoundException {
	        Magazines magazines = magazineRepository.findByName(magazinesname)
	        .orElseThrow(() -> new ResourceNotFoundException("book not found for this name :: " + magazinesname));

	        magazines.setRackno(magazinesDetails.getRackno());
	        magazines.setName(magazinesDetails.getName());
	        magazines.setDob(magazinesDetails.getDob());
	       
	        
	        final Magazines updatedmagazines = magazineRepository.save(magazines);
	        return ResponseEntity.ok(updatedmagazines);
	    }

	
	@DeleteMapping(  "/magazines/{name}")
	public Map<String, Boolean> deletemagazines(@PathVariable(value = "name") String magazinesname)
	         throws ResourceNotFoundException {
	        Magazines magazines = magazineRepository.findByName(magazinesname)
	       .orElseThrow(() -> new ResourceNotFoundException("magazine not found for this name :: " + magazinesname));

	       magazineRepository.delete(magazines);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	}
