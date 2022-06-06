package com.qa.soundrave.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.soundrave.domain.Song;


@Repository
public interface SongRepo extends JpaRepository<Song, Long> {
	
//	// Find by Make
//	@Query(value = "SELECT * from Car where make = ?1", nativeQuery = true)
//	List<Car> findCarByMake(String make);
//	
//	// Find by Horsepower
//    @Query("SELECT hp from Car hp WHERE hp.horsepower = ?1")
//    List<Car> findCarByHorsepower(int horsepower);
//	
	
}
