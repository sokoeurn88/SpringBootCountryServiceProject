package com.countryservice.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.controllers.AddResponse;
import com.countryservice.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryrep;
	
////	static HashMap<Integer,Country> countryIdMap;
//	
//	//create constructor
////	public CountryService() {
////		countryIdMap=new HashMap<Integer,Country>();
////		
////		Country indiaCountry=new Country(1,"India","Delhi");
////		Country usaCountry=new Country(2, "USA","Wshington");
////		Country ukCountry=new Country(3,"UK", "London");
////		
////		countryIdMap.put(1,indiaCountry);
////		countryIdMap.put(2, usaCountry);
////		countryIdMap.put(3, ukCountry);
////	}
//	
//	public List getAllCountries() {
////		List countries=new ArrayList(countryIdMap.values());
////		return countries;
//	}
//	
//	public Country getCountrybyID(int id) {
////		Country country=countryIdMap(id);
////		return country;
//	}
//	
//	//should not create this method, but want to eliminate error
////	private Country countryIdMap(int id) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
//	public Country getCountrybyName(String countryName) {
////		Country country=null;
////		for(int i:countryIdMap.keySet()) {
////			if(countryIdMap.get(i).getCountryName().equals(countryName))
////				country=countryIdMap.get(i);
////		}
////		return country;
//	}
//	
//	public Country addCountry(Country country) {
////		country.setId(getMaxId());
////		countryIdMap.put(country.getId(), country);
////		return country;
//	}
//	
//	//Utility method to get max id
//	public static int getMaxId() {
////		int max=0;
////		for(int id:countryIdMap.keySet())
////			if(max<=id)
////				max=id;
////		return max+1;
//	}
//	
//	public Country updateCountry(Country country) {
////		if(country.getId()>0)
////			countryIdMap.put(country.getId(), country);
////		return country;
//	}
//	
//	public AddResponse deleteCountry(int id) {
////		countryIdMap.remove(id);
////		AddResponse res=new AddResponse();
////		res.setMsg("Country deleted...");
////		res.setId(id);
////		return res;
//	}
	
	
	public List<Country> getAllCountries(){
		return countryrep.findAll();
	}
	
	public Country getCountrybyId(int id) {
		return countryrep.findById(id).get();
	}
	
	public Country getCountrybyName(String countryName) {
		List<Country> countries = countryrep.findAll();
		Country country = null;
		
		for(Country con:countries) {
			if(con.getCountryName().equalsIgnoreCase(countryName))
				country=con;
		}
		return country;
		
	}
	
	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryrep.save(country);
		return country;
	}
	
	public int getMaxId() {
		return countryrep.findAll().size()+1;
	}
	
	public Country updateCountry(Country country) {
		countryrep.save(country);
		return country;
	}
	
	public AddResponse deleteCountry(int id) {
		countryrep.deleteById(id);
		
		AddResponse res=new AddResponse();
		res.setMsg("Country Deleted !");
		res.setId(id);
		return res;
	}
	
}
