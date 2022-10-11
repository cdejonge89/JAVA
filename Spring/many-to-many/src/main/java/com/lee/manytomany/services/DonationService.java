package com.lee.manytomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.manytomany.models.Donation;
import com.lee.manytomany.models.User;
import com.lee.manytomany.repositories.DonationRepository;

@Service
public class DonationService {
	@Autowired
	private DonationRepository donationRepo;
	
	@Autowired
	private UserService userService;
	
	//CREATE
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
	
	//EDIT
	public Donation editDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	//DELETE
	public void deleteDonation(Long donationId) {
		donationRepo.deleteById(donationId);
	}
	
	//RECEIVE DONATION
	public void receiveDonation(Long donationId, Long userId) {
		Donation donation = this.oneDonation(donationId);
		User user = userService.oneUser(userId);
		donation.getReceivers().add(user);
		donation.setQuantity(donation.getQuantity()-1);
		donationRepo.save(donation);
	}
	
	//RETURN DONATION
	public void returnDonation(Long donationId, Long userId) {
		Donation donation = this.oneDonation(donationId);
		User user = userService.oneUser(userId);
		donation.getReceivers().remove(user);
		donation.setQuantity(donation.getQuantity()+1);
		donationRepo.save(donation);
	}
}
