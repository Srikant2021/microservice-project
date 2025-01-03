package com.utb.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.utb.userService.entities.Rating;
import com.utb.userService.external.services.HotelServices;
import com.utb.userService.external.services.RatingServices;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication implements CommandLineRunner {
	/*
	 * @Autowired private RatingServices ratingServices;
	 */

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Rating rating =
		 * Rating.builder().rating(11).userId("123").hotelId("123").feedback("tesing").
		 * build(); ratingServices.createRating(rating);
		 * System.out.println("done.....................");
		 */
	}

}
