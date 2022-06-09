package com.qa.soundrave.dto;

import java.util.List;

import com.qa.soundrave.domain.Song;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArtistDTO {

	private Long id;
	private String name;
	private List<SongDTO> songs;
	
	public ArtistDTO(Long id2, String name2, List<Song> songs2) {
	}
}