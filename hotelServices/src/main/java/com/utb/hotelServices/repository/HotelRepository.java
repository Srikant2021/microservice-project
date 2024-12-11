package com.utb.hotelServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utb.hotelServices.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
