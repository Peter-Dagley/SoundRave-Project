package com.qa.soundrave.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.soundrave.domain.Artist;
import com.qa.soundrave.dto.ArtistDTO;
import com.qa.soundrave.exception.ArtistException;
import com.qa.soundrave.repo.ArtistRepo;

@SpringBootTest
public class ArtistServiceTest {

	@Autowired
	private ArtistService service;

	@MockBean
	private ArtistRepo repo;

	// Create
	@Test
	public void testCreate() {
		final Artist artist = new Artist();
		final ArtistDTO artistDTO = new ArtistDTO();

		Mockito.when(this.repo.save(artist)).thenReturn(artist);
		assertEquals(artistDTO, this.service.createArtist(artist));
		Mockito.verify(this.repo, Mockito.times(1)).save(artist);
	}

	// Read All
	@Test
	public void testReadAll() {
		final List<Artist> artists = new ArrayList<Artist>();

		Mockito.when(this.repo.findAll()).thenReturn(artists);
		assertEquals(artists, this.service.readAll());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	// Read by ID
	@Test
	public void testReadById() throws ArtistException {
		final Long id = 1L;
		final Artist artist = new Artist();
		final ArtistDTO artistDTO = new ArtistDTO();

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(artist));
		assertEquals(artistDTO, this.service.readById(id));
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}

	// Update
	@Test
	public void testUpdate() throws ArtistException {
		final Long id = 1L;
		final Artist artist = new Artist();
		final Artist artist2 = new Artist();
		final ArtistDTO artistDTO = new ArtistDTO();

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(artist));
		Mockito.when(this.repo.save(artist2)).thenReturn(artist2);
		assertEquals(artistDTO, this.service.update(id, artist));

		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).save(artist2);
	}

	// Delete
	@Test
	public void testDelete() throws ArtistException {
		final Long id = 1L;
		final Artist artist = new Artist();
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(artist));
		
		final boolean result = this.service.deleteArtist(id);

		assertEquals(result, this.service.deleteArtist(id));

		Mockito.verify(this.repo, Mockito.times(2)).findById(Mockito.anyLong());
	}

}
