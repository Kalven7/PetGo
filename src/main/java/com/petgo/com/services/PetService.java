package com.petgo.com.services;

import java.util.List;

import com.petgo.com.entities.Pet;

public interface PetService {

	List<Pet> findAll();

	Pet add(Pet obj);

	Pet findById(Long id);

	Pet update(Pet obj);

	void remove(Long id);

}
