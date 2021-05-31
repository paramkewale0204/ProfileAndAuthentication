package com.org.media.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.media.assignment.model.Profile;
import com.org.media.assignment.service.ProfileService;

@RestController
@RequestMapping("/org")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;

	
	@GetMapping("/getallprofile")
	public List<Profile> getAllCategory(){
		return profileService.getAll();
	}
	
	@GetMapping("/getprofile/{id}")
	public Optional<Profile> get(@PathVariable int id) {
		Optional<Profile> employeeObj = profileService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("Employee not found for the Id:"+id);
		}
		return employeeObj;
	}
	
	@PostMapping("/addprofile")
	public Profile save(@RequestBody Profile employeeObj) {
		profileService.save(employeeObj);
		return employeeObj;
	}
	
	@DeleteMapping("/deleteprofile/{id}")
	public String delete(@PathVariable int id) {
		profileService.delete(id);
		return "Employee has been deleted with id:"+id;
	}
	
	@PutMapping("/updateprofile")
	public Profile update(@RequestBody Profile profileObj) {
		profileService.save(profileObj);
		return profileObj;
	}
}
