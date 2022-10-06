package com.lee.languages.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lee.languages.models.Language;
import com.lee.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
//	@Autowired
//	private LanguageRepository langRepo;
	
	//FIND ALL
	public List<Language> allLang() {
		return langRepo.findAll();
	}
	
	//FIND ONE
	public Language oneLang(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	//CREATE
	public Language create(Language newLanguage) {
		return langRepo.save(newLanguage);
	}
	
	//EDIT
	public Language edit(Language updatedLang) {
		return langRepo.save(updatedLang);
	}
	
	//DELETE
	public void delete(Long id) {
		langRepo.deleteById(id);
	}
	
}
