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

import com.qa.soundrave.domain.Song;
import com.qa.soundrave.dto.SongDTO;
import com.qa.soundrave.exception.SongException;
import com.qa.soundrave.repo.SongRepo;

@SpringBootTest
public class SongServiceTest {

	@Autowired
	private SongService service;
		
	@MockBean
	private SongRepo repo;
	
	// Create
	@Test
	public void testCreate() {
		final Song song = new Song();
		final SongDTO songDTO = new SongDTO();

		Mockito.when(this.repo.save(song)).thenReturn(song);
		assertEquals(songDTO, this.service.createSong(song));
		Mockito.verify(this.repo, Mockito.times(1)).save(song);
	}
	
	// Read All
	@Test
	public void testReadAll() {
		final List<Song> songs = new ArrayList<Song>();

		Mockito.when(this.repo.findAll()).thenReturn(songs);
		assertEquals(songs, this.service.readAll());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	// Read by ID
	@Test
	public void testReadById() throws SongException {
		final Long id = 1L;
		final Song song = new Song();
		final SongDTO songDTO = new SongDTO();
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(song));
		assertEquals(songDTO, this.service.readById(id));
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}

	// Update
	@Test
	public void testUpdate() throws SongException {
		final Long id = 1L;
		final Song song = new Song();
		final Song song2 = new Song();
		final SongDTO songDTO = new SongDTO();
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(song));
		Mockito.when(this.repo.save(song2)).thenReturn(song2);
		assertEquals(songDTO, this.service.update(id, song));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).save(song2);
	}
	
	// Delete
	@Test
	public void testDelete() throws SongException {
		final Long id = 1L;
		final Song song = new Song();
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(song));
		
		final boolean result = this.service.deleteSong(id);
		
		assertEquals(result, this.service.deleteSong(id));	
		
		Mockito.verify(this.repo, Mockito.times(2)).findById(Mockito.anyLong());		
	}
	

}

