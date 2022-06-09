package com.qa.soundrave.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.soundrave.domain.Artist;
import com.qa.soundrave.exception.ArtistException;
import com.qa.soundrave.repo.ArtistRepo;
import com.qa.soundrave.services.ArtistService;

@SpringBootTest
public class ArtistControllerTest {
	
	@Autowired
	private ArtistController controller;
	
	@MockBean
	private ArtistService service;
	
	@MockBean
	private ArtistRepo repo;
	
	
	// Create
	@Test
	public void createTest() {
		final Artist artist = new Artist();
		assertEquals(new ResponseEntity<>(this.service.createArtist(artist), HttpStatus.CREATED), this.controller.createArtist(artist));
	}
	
	// Read All
	@Test
	public void readAllTest() {
		assertEquals(new ResponseEntity<>(this.service.readAll(), HttpStatus.OK), this.controller.read());
	}
	
	// Read By ID
	@Test
	public void readByIdTest() throws ArtistException {
		final Long id = 1L;
		assertEquals(new ResponseEntity<>(this.service.readById(id), HttpStatus.OK), this.controller.artistById(id));
	}
	
	// Update
	@Test
	public void updateTest() throws ArtistException {
		final Long id = 1L;
		final Artist artist = new Artist();
		assertEquals(new ResponseEntity<>(this.service.update(id, artist), HttpStatus.ACCEPTED), this.controller.updateArtist(id, artist));
	}
	
	// Delete
	@Test
	public void deleteTest() throws ArtistException {
		final Long id = 1L;
		assertEquals(new ResponseEntity<>(this.service.deleteArtist(id), HttpStatus.NO_CONTENT), this.controller.deleteArtist(id));
	}
	

}

