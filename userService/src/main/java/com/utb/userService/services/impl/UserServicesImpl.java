package com.utb.userService.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.utb.userService.entities.Hotel;
import com.utb.userService.entities.Rating;
import com.utb.userService.entities.User;
import com.utb.userService.exception.ResourceNotFoundException;
import com.utb.userService.external.services.HotelServices;
import com.utb.userService.repositoreis.UserRepository;
import com.utb.userService.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelServices hotelServices;

	private Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

	@Override
	public User saveUser(User user) {
		String randomId = UUID.randomUUID().toString();
		user.setId(randomId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with the provided id " + userId));
		Rating[] ratingsOfUser = restTemplate
				.getForObject("http://RATINGSERVICES/hotelRating/getRatingsByUser/" + user.getId(), Rating[].class);

		logger.info("{}", ratingsOfUser);

		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

		List<Rating> ratingList = ratings.stream().map(rating -> {
			// using rest template
//			ResponseEntity<Hotel> forEntity = restTemplate
//					.getForEntity("http://HOTELSERVICES/hotel/getHotel/" + rating.getHotelId(), Hotel.class);
			// using feignclient
			Hotel hotel = hotelServices.getHotel(rating.getHotelId());
//			logger.info("response status code: {} ", forEntity.getStatusCode());
					rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);
		return user;
	}

}
