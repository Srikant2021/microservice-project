package com.utb.ratingServices.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utb.ratingServices.entity.Rating;
import com.utb.ratingServices.repository.RatingRepository;
import com.utb.ratingServices.services.RatingServices;

@Service
public class RatingServicesImpl implements RatingServices {
	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public Rating create(Rating rating) {
		String randomId = UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
