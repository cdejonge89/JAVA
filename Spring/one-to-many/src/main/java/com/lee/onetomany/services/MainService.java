package com.lee.onetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.onetomany.models.Donation;
import com.lee.onetomany.models.User;
import com.lee.onetomany.repositories.DonationRepository;
import com.lee.onetomany.repositories.UserRepository;

@Service
public class MainService {
	
	@Autowired
	private DonationRepository donationRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	// find all donations
	public List<Donation> allDonations(){
		return donationRepo.findAll();
	}
	
	// find all users
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	// create donations
	public Donation createDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	// create users
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	//FIND ONE USER
	public User oneUser(Long userId) {
		Optional<User> optionalUser = userRepo.findById(userId);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	//FIND ONE DONATION
	public Donation oneDonation(Long donationId) {
		Optional<Donation> optionalDonation = donationRepo.findById(donationId);
		if(optionalDonation.isPresent()) {
			return optionalDonation.get();
		} else {
			return null;
		}
	}
	
	//EDIT DONATION
	public Donation editDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	
	//DELETE DONATION
	public void deleteDonation(Long donationId) {
		donationRepo.deleteById(donationId);
	}
	
}
