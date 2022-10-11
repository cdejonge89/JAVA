package com.lee.manytomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lee.manytomany.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
	List<Donation> findAll();
}
