package com.qa.soundrave.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.soundrave.domain.Artist;
import com.qa.soundrave.dto.ArtistDTO;
import com.qa.soundrave.exception.ArtistException;
import com.qa.soundrave.repo.ArtistRepo;



@Service
public class ArtistService {

	@Autowired
	private ArtistRepo repo;
	
	private ModelMapper mapper;
	
	@Autowired
	public ArtistService(ArtistRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	// DTO 
	private ArtistDTO mapToDTO(Artist artist) {
		return this.mapper.map(artist, ArtistDTO.class);
	}

	
	// Create
	public ArtistDTO createArtist(Artist artist) {
		return this.mapToDTO(this.repo.save(artist));
	}
		
	// Read All
	public List<ArtistDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	// Read by ID
	public ArtistDTO readById(Long id) throws ArtistException {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(ArtistException::new));
	}
	
	// Update
	public ArtistDTO update(Long id, Artist newArtist) throws ArtistException {
		Artist exist = this.repo.findById(id).orElseThrow(ArtistException::new);
				
		exist.setName(newArtist.getName());
		// Might need song list too?
		
		return this.mapToDTO(this.repo.save(exist));
	}
	
	// Delete
	public boolean deleteArtist(Long id) throws ArtistException {
		this.repo.findById(id).orElseThrow(ArtistException::new);
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
		
}
