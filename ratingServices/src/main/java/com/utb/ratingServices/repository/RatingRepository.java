package com.utb.ratingServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utb.ratingServices.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
	// custom finding methods;
	List<Rating> findByUserId(String userId);

	List<Rating> findByHotelId(String hotelId);
}
