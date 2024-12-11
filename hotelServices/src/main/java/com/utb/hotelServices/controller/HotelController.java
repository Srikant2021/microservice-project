package com.utb.hotelServices.controller;

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

import com.utb.hotelServices.entities.Hotel;
import com.utb.hotelServices.services.HotelServices;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelServices hotelServices;

	@PostMapping("createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelServices.create(hotel));
	}

	@GetMapping("getHotel/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelServices.get(id));
	}

	@GetMapping("getHotels")
	public ResponseEntity<List<Hotel>> getAllHotel() {
		return ResponseEntity.ok(hotelServices.getAll());
	}

}
