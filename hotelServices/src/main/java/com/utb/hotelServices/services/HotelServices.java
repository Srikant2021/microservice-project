package com.utb.hotelServices.services;

import java.util.List;

import com.utb.hotelServices.entities.Hotel;

public interface HotelServices {
	// create
	Hotel create(Hotel hotel);

	// getall
	List<Hotel> getAll();

	// get single
	Hotel get(String id);
}
