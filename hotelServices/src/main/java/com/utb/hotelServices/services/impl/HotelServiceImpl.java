package com.utb.hotelServices.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utb.hotelServices.entities.Hotel;
import com.utb.hotelServices.exception.ResourceNotFoundException;
import com.utb.hotelServices.repository.HotelRepository;
import com.utb.hotelServices.services.HotelServices;

@Service
public class HotelServiceImpl implements HotelServices {

	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel not found with given id."));
	}

}
