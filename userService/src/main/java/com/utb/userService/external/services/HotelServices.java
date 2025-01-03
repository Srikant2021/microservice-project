package com.utb.userService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.utb.userService.entities.Hotel;

@FeignClient(name = "HOTELSERVICES")
public interface HotelServices {

	@GetMapping("hotel/getHotel/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);
}
