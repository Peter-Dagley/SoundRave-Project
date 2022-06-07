package com.qa.soundrave.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SongDTO {

	private Long id;
	private String title;
//	private String artist;
	private String genre;
	private double length;

//	private Artist artist;
}
