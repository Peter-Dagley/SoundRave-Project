package com.qa.soundrave.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.soundrave.domain.Artist;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Long> {

}
