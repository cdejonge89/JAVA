package com.lee.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lee.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll();
	List<Lookify> findByArtistContaining(String keyword);
	List<Lookify> findByTitleContaining(String title);
	
	List<Lookify> findAllByOrderByRatingDesc();
	List<Lookify> findTopByOrderByRatingDesc();
	
	@Query(value = "SELECT * FROM lookify ORDER BY rating DESC LIMIT 10", nativeQuery = true) 
	List<Lookify> getTopTen();
}
