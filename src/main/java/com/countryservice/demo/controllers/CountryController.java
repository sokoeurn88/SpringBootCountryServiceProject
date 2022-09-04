package com.countryservice.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.services.CountryService;

@RestController
public class CountryController {
//	
//	//CountryService countryService=new CountryService();	
//	@Autowired
//	CountryService countryService;
//	
//	@GetMapping("/getcountries")
//	public List getCountries() {
//		return countryService.getAllCountries();
//	}
//	
//	@GetMapping("/getcountries/{id}")
//	public Country getCountryById(@PathVariable(value="id") int id) {
//		return countryService.getCountrybyID(id);		
//	}
//	
//	@GetMapping("/getcountries/countryname")
//	public Country getCountryByName(@RequestParam(value="name")String countryName) {
//		return countryService.getCountrybyName(countryName);
//	}
//	
//	@PostMapping("/addcountry")
//	public Country addCountry(@RequestBody Country country) {
//		return countryService.addCountry(country);
//	}
//	
//	@PutMapping("/updatecountry")
//	public Country updateCountry(@RequestBody Country country) {
//		return countryService.updateCountry(country);
//	}
//	
//	@DeleteMapping("/deletecountry/{id}")
//	public AddResponse deleteCountry(@PathVariable(value="id") int id) {
//		return countryService.deleteCountry(id);
//	}
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getcountries")
	public List<Country> getCountries() {
		return countryService.getAllCountries();
	}
	
	@GetMapping("/getcountries/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable(value="id") int id){
		try {
			Country country=countryService.getCountrybyId(id);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getcountries/countryname")
	public ResponseEntity<Country> getCountryByName(@RequestParam(value="name")String countryName) {
		try {
			Country country=countryService.getCountrybyName(countryName);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}
	
	@PutMapping("/updatecountry")
	public ResponseEntity<Country> updateCountry(@PathVariable(value="id")int id,@RequestBody Country country) {
		
		try {
			Country existcountry=countryService.getCountrybyId(id);
			existcountry.setCountryName(country.getCountryName());
			existcountry.setCountryCapital(country.getCountryCapital());
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id")int id) {
		return countryService.deleteCountry(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
