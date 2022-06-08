package com.qa.soundravetests.services;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.soundrave.domain.Song;
import com.qa.soundrave.dto.SongDTO;
import com.qa.soundrave.repo.SongRepo;
import com.qa.soundrave.services.SongService;

public class SongServiceTest {

	private SongService service;
	
	@MockBean
	private SongRepo repo;
		
	@Test
	public void testCreate() {
		final Song song = new Song();
		final SongDTO songDTO = new SongDTO();

		Mockito.when(this.repo.save(song)).thenReturn(song);

		assertEquals(song, this.service.createSong(song));

		Mockito.verify(this.repo, Mockito.times(1)).save(song);
	}
	
	@Test
	public void testReadAll() {
		final List<Song> songs = new ArrayList<Song>();

		Mockito.when(this.repo.findAll()).thenReturn(songs);

		assertEquals(songs, this.service.readAll());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	
}

