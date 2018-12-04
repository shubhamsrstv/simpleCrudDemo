package com.jpa.demoCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa.demoCrud.beans.Profile;
import com.jpa.demoCrud.services.Services;

@org.springframework.stereotype.Controller
public class Controller 
{
	@Autowired
	Services services;
	
	@RequestMapping(value="/demo", method = RequestMethod.POST)
	@ResponseBody
	private String demoMethod() {
		return "Restful webservices is working with Spring boot.";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	@ResponseBody
	private Profile createProfile(@RequestParam String name, String hometown) {
		return services.createProfile(name, hometown);
	}
	
	@RequestMapping(value="/read", method = RequestMethod.POST)
	@ResponseBody
	private Profile readProfile(@RequestParam int id) {
		return services.readProfile(id);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	private Profile updateProfile(@RequestParam int id, String hometown) {
		return services.updateProfile(id, hometown);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	private String deleteProfile(@RequestParam int id) {
		return services.deleteProfile(id);
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	@ResponseBody
	private Profile searchProfile(@RequestParam String name) {
		return services.searchProfile(name);
	}
}
