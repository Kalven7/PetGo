package com.petgo.com.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petgo.com.entities.Pet;
import com.petgo.com.services.PetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pets")
@AllArgsConstructor
public class PetController {

	private PetService service;

	@GetMapping
	public ResponseEntity<List<Pet>> findAll() {
		List<Pet> pets = service.findAll();
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Pet> findById(@PathVariable Long id) {
		Pet pet = service.findById(id);
		return new ResponseEntity<>(pet, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Pet> add(@RequestBody Pet obj) {
		Pet pet = service.add(obj);
		return new ResponseEntity<>(pet, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Pet> update(@PathVariable Long id, @RequestBody Pet obj) {
		obj.setId(id);
		Pet updatePet = service.update(obj);
		return new ResponseEntity<>(updatePet, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public void remove(@PathVariable Long id) {
		service.remove(id);
	}

}
