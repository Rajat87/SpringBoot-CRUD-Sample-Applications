package com.springboot.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.model.Country;
import com.springboot.rest.model.PaymentDetails;
import com.springboot.rest.service.PaymentService;

@RestController
public class CountryController {
	PaymentService paymentService ;
	
	public CountryController(PaymentService paymentService) {
		this.paymentService=paymentService;
	}
	
	@GetMapping("ListOfCountry")
	public List<Country> returnCountry() {
		List<Country> countries = List.of(Country.giveMeCountry("India", 3000),
				Country.giveMeCountry("China", 5000),
				Country.giveMeCountry("USA", 2000)
				);
		return countries;  
		//return "Hello"; 
	}
	
	
	@GetMapping("SingleCountry/{name}")  // This can be used let's say when we are having a dynamic single object and we want to fetch it based on a attribute
	public Country returnSingleCountry(@PathVariable String name) {
		Country country = Country.giveMeCountry("India", 1000);
		return country;  
		//return "Hello"; 
	}
	
	
	@GetMapping("Country")
	public ResponseEntity<Country> returnCountryEntity() {
		/*List<Country> countries = List.of(Country.giveMeCountry("India", 3000),
				Country.giveMeCountry("China", 5000),
				Country.giveMeCountry("USA", 2000)
				);*/
		return ResponseEntity.status(HttpStatus.ACCEPTED) // This gives me an object
				.header("Name", "Rajat") // This gives me an object
				.body(Country.giveMeCountry("Rajat", 250));  // This gives me an object of type ResponseEntity
		//return "Hello"; 
	}
	// Handling Exception without using Aspect
	@GetMapping("Payment")
	public ResponseEntity<?> returnPaymentDetails() {   // This specifies that this method can take any return type
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Random", "101").body(paymentService.makePayment(1000));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).header("Failed", "102").body("Nothing Meaningful");
		}
		
	}
	
	@PostMapping("Payment")
	public ResponseEntity<?> setPaymentDetails(@RequestBody PaymentDetails details){
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("I got the value", "Done").body(details);
	}
	
}
