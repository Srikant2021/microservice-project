package com.utb.userService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.utb.userService.entities.Rating;

@FeignClient(name = "RATINGSERVICES")
public interface RatingServices {
	// this is not complete its not working in test class video no 17

	@PostMapping("hotelRating/create")
	ResponseEntity<Rating> createRating(@RequestBody Rating rating);

	/*
	 * @PutMapping("hotelRating/update/ratingId") ResponseEntity<Rating>
	 * updateRating(@PathVariable String ratingId, Rating rating);
	 * 
	 * @DeleteMapping("hotelRating/delete/ratingId") Rating
	 * deleteRating(@PathVariable String ratingId);
	 */

}
