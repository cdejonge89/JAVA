package com.lee.onetomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lee.onetomany.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long>{
	//FIND ALL
	List<Donation> findAll();
}
