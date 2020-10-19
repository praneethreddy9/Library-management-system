package com.dxc.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.dxc.model.Magazines;

public interface MagazineRepository extends CrudRepository<Magazines, String> {

	Optional<Magazines> findByName(String magazinename);

}
