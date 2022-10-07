package com.lee.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lee.lookify.models.Lookify;
import com.lee.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookRepo;
	public LookifyService(LookifyRepository lookRepo) {
		this.lookRepo = lookRepo;
	}
    
    //FIND ALL
    public List<Lookify> allMusic() {
    	return lookRepo.findAll();
    }
    
    //CREATE
    public Lookify create(Lookify newSong) {
    	return lookRepo.save(newSong);
    }
    
    //FIND ONE
    public Lookify findOne(Long id) {
    	Optional<Lookify> optionalLook = lookRepo.findById(id);
    	if(optionalLook.isPresent()) {
    		return optionalLook.get();
    	} else {
    		return null;
    	}
    }
    
    //EDIT
    public Lookify edit(Lookify updateSong) {
    	return lookRepo.save(updateSong);
    }
    
    //DELETE
    public void delete(Long id) {
    	lookRepo.deleteById(id);
    }
    
    //SEARCH
	public List<Lookify> findByArtist(String artist) {
		return lookRepo.findByArtistContaining(artist);
	}
	
	public List<Lookify> findByTitle(String title) {
		return lookRepo.findByTitleContaining(title);
	}
	
	public List<Lookify> topTen() {
		return lookRepo.getTopTen();
	}
}
