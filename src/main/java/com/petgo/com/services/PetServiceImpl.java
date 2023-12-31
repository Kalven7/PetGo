package com.petgo.com.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petgo.com.entities.Pet;
import com.petgo.com.repositories.PetRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {

	private PetRepository repo;

	@Override
	public List<Pet> findAll() {
		return repo.findAll();
	}

	@Override
	public Pet add(Pet obj) {
		return repo.save(obj);
	}

	@Transactional(readOnly = true)
	public Pet findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Pet update(Pet obj) {
		return repo.save(obj);
	}

	@Override
	public void remove(Long id) {
		repo.deleteById(id);

	}

}
