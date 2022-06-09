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

import com.qa.soundrave.domain.Song;
import com.qa.soundrave.dto.SongDTO;
import com.qa.soundrave.exception.SongException;
import com.qa.soundrave.services.SongService;

@RestController
@RequestMapping("/song")
@CrossOrigin
public class SongController {

	private SongService service;
	
	@Autowired
	public SongController(SongService service) {
		this.service = service;
	}
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<SongDTO> createSong(@RequestBody Song song) {
		return new ResponseEntity<>(this.service.createSong(song), HttpStatus.CREATED);
	}
	
	// Read
	@GetMapping("/read")
	public ResponseEntity<List<SongDTO>> read() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);	
	}

	
	// Read by ID
	@GetMapping("/read/{id}")
	public ResponseEntity<SongDTO> songById(@PathVariable Long id) throws SongException {
		return new ResponseEntity<>(this.service.readById(id), HttpStatus.OK);
	}
		
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<SongDTO> updateSong(@PathVariable Long id, @RequestBody Song song) throws SongException {
		return new ResponseEntity<>(this.service.update(id, song), HttpStatus.ACCEPTED);
	}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteSong(@PathVariable Long id) throws SongException {
		return new ResponseEntity<>(this.service.deleteSong(id), HttpStatus.NO_CONTENT);	
	}
		
}
