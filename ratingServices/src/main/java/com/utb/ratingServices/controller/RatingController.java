package com.utb.ratingServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utb.ratingServices.entity.Rating;
import com.utb.ratingServices.services.RatingServices;

@RestController
@RequestMapping("hotelRating")
public class RatingController {

	@Autowired
	private RatingServices ratingServices;

	@PostMapping("create")
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.create(rating));
	}

	@GetMapping("getRatings")
	public ResponseEntity<List<Rating>> getRatings() {
		return ResponseEntity.ok(ratingServices.getRatings());
	}

	@GetMapping("getRatingsByUser/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(ratingServices.getRatingsByUserId(userId));
	}

	@GetMapping("getRatigsByhotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
		return ResponseEntity.ok(ratingServices.getRatingsHotelId(hotelId));
	}
}
