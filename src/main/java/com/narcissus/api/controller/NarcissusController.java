package com.narcissus.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.narcissus.api.dto.UserDTO;
import com.narcissus.api.entity.UserEntity;
import com.narcissus.api.service.UserService;
import com.narcissus.api.service.exception.CustomException;

@RestController
public class NarcissusController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	@ResponseBody
	public String signup(@RequestBody UserDTO userDTO) {
		try {
			final UserEntity user = new UserEntity();
			user.setCpf(userDTO.getCpf());
			user.setEmail(userDTO.getEmail());
			user.setKey(userDTO.getPassword());
			user.setName(userDTO.getName());
			
			userService.save(user);
		}	catch (CustomException custom) {
			throw new ResponseStatusException(422, custom.getMessage(), custom);
		}
		
		return "{'success': true}";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public UserEntity login(@RequestBody UserDTO userDTO) {
		System.out.println("SL:DS:LD " + userDTO.getEmail() + "SKLDLSKDLS");
		UserEntity user;
		try {
			user = userService.login(userDTO.getEmail(), userDTO.getPassword());
		}	catch (CustomException custom) {
			System.out.println("SL:DS:LD " + custom.getMessage() + "SKLDLSKDLS");
			throw new ResponseStatusException(422, custom.getMessage(), custom);
		}
		
		return user;
	}
	
}
