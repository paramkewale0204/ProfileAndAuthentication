package com.org.media.assignment.service;

import java.util.List;
import java.util.Optional;

import com.org.media.assignment.model.Profile;

public interface ProfileService {
	
	List<Profile> getAll();
	
	Optional<Profile> get(int id);
	
	void save(Profile profile);
	
	void delete(int id); 
	
	void update(Profile profile);

}
