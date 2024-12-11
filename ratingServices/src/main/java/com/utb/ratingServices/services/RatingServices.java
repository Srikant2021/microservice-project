package com.utb.ratingServices.services;

import java.util.List;

import com.utb.ratingServices.entity.Rating;

public interface RatingServices {
	// create rating
	Rating create(Rating rating);

	// get all rating
	List<Rating> getRatings();

	// get all rating by user id
	List<Rating> getRatingsByUserId(String userId);

	// get all by hotel
	List<Rating> getRatingsHotelId(String hotelId);

}
