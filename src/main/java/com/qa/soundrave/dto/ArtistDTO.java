package com.qa.soundrave.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArtistDTO {

	private Long id;
	private String name;
	private List<SongDTO> songs;
	
	@Override
	public String toString() {
		return "ArtistDTO [id=" + id + ", name=" + name + ", songs=" + songs + "]";
	}

}