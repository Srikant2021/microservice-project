package com.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.utb.userService.UserServiceApplication;
import com.utb.userService.entities.Rating;
import com.utb.userService.external.services.RatingServices;

@SpringBootTest(classes = UserServiceApplication.class)
class UserServiceApplicationTests {

//	@Autowired
//	private RatingServices ratingServices;

	@Test
	void contextLoads() {
	}

//	@Test
//	void createRating() {
//		Rating rating = Rating.builder().rating(11).userId("123").hotelId("123").feedback("tesing").build();
//		 ratingServices.createRating(rating);
//		System.out.println("done.....................");
//	}

}
