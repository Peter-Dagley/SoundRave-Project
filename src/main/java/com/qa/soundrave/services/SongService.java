package com.qa.soundrave.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.soundrave.domain.Song;
import com.qa.soundrave.dto.SongDTO;
import com.qa.soundrave.exception.SongException;
import com.qa.soundrave.repo.SongRepo;

@Service
public class SongService {

	@Autowired
	private SongRepo repo;
	
	private ModelMapper mapper;
	
	@Autowired
	public SongService(SongRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	// DTO 
	private SongDTO mapToDTO(Song song) {
		return this.mapper.map(song, SongDTO.class);
	}

	// Create
	public SongDTO createSong(Song song) {
		return this.mapToDTO(this.repo.save(song));
	}
		
	// Read All
	public List<SongDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	// Read by ID
	public SongDTO readById(Long id) throws SongException {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(SongException::new));
	}
	
	// Update
	public SongDTO update(Long id, Song newSong) throws SongException {
		Song exist = this.repo.findById(id).orElseThrow(SongException::new);
				
		exist.setTitle(newSong.getTitle());
		exist.setArtist(newSong.getArtist());
		exist.setGenre(newSong.getGenre());
		exist.setLength(newSong.getLength());
		
		return this.mapToDTO(this.repo.save(exist));
	}
	
	// Delete
	public boolean deleteSong(Long id) throws SongException {
		this.repo.findById(id).orElseThrow(SongException::new);
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
//	// Find by Make
//	public List<CarDTO> findCarByMake(String make) {
//		return this.repo.findCarByMake(make).stream().map(this::mapToDTO).collect(Collectors.toList());
//	}
//	
//	// Find by Horsepower
//	public List<CarDTO> findCarByHorsepower(int horsepower) {
//		return this.repo.findCarByHorsepower(horsepower).stream().map(this::mapToDTO).collect(Collectors.toList());
//	}
	
	
	
}
