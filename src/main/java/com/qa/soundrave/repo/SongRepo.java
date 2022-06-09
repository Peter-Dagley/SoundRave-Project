package com.qa.soundrave.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.soundrave.domain.Song;


@Repository
public interface SongRepo extends JpaRepository<Song, Long> {
		
}
