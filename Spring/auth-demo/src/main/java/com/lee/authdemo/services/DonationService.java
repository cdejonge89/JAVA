package com.lee.authdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.authdemo.models.Donation;
import com.lee.authdemo.repositories.DonationRepository;

@Service
public class DonationService {
	@Autowired
	private DonationRepository donationRepo;
	
	// CREATE
	public Donation createDonation(Donation newDonation) {
		return donationRepo.save(newDonation);
	}
	
	//FIND ALL
	public List<Donation> allDonations() {
		return donationRepo.findAll();
	}
	
	//FIND ONE
	public Donation oneDonation(Long id) {
		Optional<Donation> optionalDonation = donationRepo.findById(id);
		if(optionalDonation.isPresent()) {
			return optionalDonation.get();
		} else {
			return null;
		}
	}
	
	//EDIT/PROCESS
	public Donation editDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	//DELETE
	public void deleteDonation(Long id) {
		donationRepo.deleteById(id);
	}
	
	
	
}
