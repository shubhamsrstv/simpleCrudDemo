package com.jpa.demoCrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demoCrud.beans.Profile;
import com.jpa.demoCrud.dao.Dao;

@Service
public class Services {

	@Autowired
	Dao dao;
	
	Profile prof = new Profile();
	
	public Profile createProfile(String name, String hometown) {
		if(name!=null && hometown!=null) {
		prof.setHometown(hometown);
		prof.setName(name);
		Profile result = dao.save(prof);
		return result;}
		else {
			return null;
		}
	}

	public Profile readProfile(int id) {
		Profile result = null;
		try {
		result = dao.findById(id).get();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(result!=null) {
		return result;}
		else {
			return null;
		}
	}

	public Profile updateProfile(int id, String hometown) {
		Profile result = null;
		try {
			result = dao.findById(id).get();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		if(result!=null) {
			result.setHometown(hometown);
			dao.save(result);
			return result;
		}
		return null;
	}

	public String deleteProfile(int id) {
		Profile result = null;
		try {
			result = dao.findById(id).get();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		if(result!=null) {
			dao.deleteById(id);
			return "Id deleted succesfully";
		}
		return "Id not found";
	}

	public Profile searchProfile(String name) {
		Profile result = null;
		try {
			result = dao.findByName(name);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		return result;
	}

}
