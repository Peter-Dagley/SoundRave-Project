package com.qa.soundrave.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.soundrave.domain.Song;
import com.qa.soundrave.exception.SongException;
import com.qa.soundrave.repo.SongRepo;
import com.qa.soundrave.services.SongService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SongControllerTest {
	
	@Autowired
	private SongController controller;
	
	@MockBean
	private SongService service;
	
	@MockBean
	private SongRepo repo;
	
	
	// Create
	@Test
	public void createTest() {
		final Song song = new Song();
		assertEquals(new ResponseEntity<>(this.service.createSong(song), HttpStatus.CREATED), this.controller.createSong(song));
	}
	
	// Read All
	@Test
	public void readAllTest() {
		assertEquals(new ResponseEntity<>(this.service.readAll(), HttpStatus.OK), this.controller.read());
	}

	// Read By ID
	@Test
	public void readByIdTest() throws SongException {
		final Long id = 1L;
		assertEquals(new ResponseEntity<>(this.service.readById(id), HttpStatus.OK), this.controller.songById(id));
	}
	
	// Update
	@Test
	public void updateTest() throws SongException {
		final Long id = 1L;
		final Song song = new Song();
		assertEquals(new ResponseEntity<>(this.service.update(id, song), HttpStatus.ACCEPTED), this.controller.updateSong(id, song));
	}
	
	// Delete
	@Test
	public void deleteTest() throws SongException {
		final Long id = 1L;
		assertEquals(new ResponseEntity<>(this.service.deleteSong(id), HttpStatus.NO_CONTENT), this.controller.deleteSong(id));
	}
	

}
