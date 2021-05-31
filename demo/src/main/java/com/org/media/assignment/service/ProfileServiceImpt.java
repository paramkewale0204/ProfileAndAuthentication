package com.org.media.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.media.assignment.model.Profile;
import com.org.media.assignment.repository.ProfileRepository;

@Service
public class ProfileServiceImpt implements ProfileService{
	
	@Autowired
	private ProfileRepository profileRepo;

	@Override
	public List<Profile> getAll() {
		List<Profile> profiles = new ArrayList<>();
		
		System.out.println("Data DB = " + profileRepo.findAll());
		
		profileRepo.findAll()
		.forEach(profiles :: add);
		
		System.out.println("Data from repo = " + profiles);
		
		return profiles;
	}

	@Override
	public Optional<Profile> get(int id) {
		return profileRepo.findById(id);
	}

	@Override
	public void save(Profile profile) {
		profileRepo.save(profile);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		profileRepo.deleteById(id);
	}

	@Override
	public void update(Profile profile) {
		
		Profile profile1 = profileRepo.findById(profile.getId()).get();
		//if(pro)
		profile1.setAddress(profile.getAddress());
		profile1.setPhone(profile.getPhone());
		profileRepo.save(profile1);
		
	}
	
	
	
	

}
