package com.qa.soundrave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.qa.soundrave.domain.Artist;
import com.qa.soundrave.dto.ArtistDTO;
import com.qa.soundrave.exception.ArtistException;
import com.qa.soundrave.services.ArtistService;

@RestController
@RequestMapping("/artist")
@CrossOrigin
public class ArtistController {

	private ArtistService service;
	
	@Autowired
	public ArtistController(ArtistService service) {
		this.service = service;
	}
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<ArtistDTO> createArtist(@RequestBody Artist artist) {
		return new ResponseEntity<>(this.service.createArtist(artist), HttpStatus.CREATED);
	}
	
	// Read
	@GetMapping("/read")
	public ResponseEntity<List<ArtistDTO>> read() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);	
	}

	
	// Read by ID
	@GetMapping("/read/{id}")
	public ResponseEntity<ArtistDTO> artistById(@PathVariable Long id) throws ArtistException {
		return new ResponseEntity<>(this.service.readById(id), HttpStatus.OK);
	}
		
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<ArtistDTO> updateArtist(@PathVariable Long id, @RequestBody Artist artist) throws ArtistException {
		return new ResponseEntity<>(this.service.update(id, artist), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteArtist(@PathVariable Long id) throws ArtistException {
		return new ResponseEntity<>(this.service.deleteArtist(id), HttpStatus.NO_CONTENT);	
	}
		
}
