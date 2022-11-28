package com.narcissus.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.narcissus.api.dto.AppointmentDTO;
import com.narcissus.api.dto.MessageDTO;
import com.narcissus.api.dto.ResponseDTO;
import com.narcissus.api.dto.UserDTO;
import com.narcissus.api.entity.AppointmentEntity;
import com.narcissus.api.entity.MessageEntity;
import com.narcissus.api.entity.UserEntity;
import com.narcissus.api.service.AppointmentService;
import com.narcissus.api.service.MessageService;
import com.narcissus.api.service.UserService;
import com.narcissus.api.service.exception.CustomException;

@RestController
public class NarcissusController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("/signup")
	@ResponseBody
	public ResponseDTO signup(@RequestBody UserDTO userDTO) {
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
		
		return new ResponseDTO(true);
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
	
	@PostMapping("/appointment")
	@ResponseBody
	public ResponseDTO appointment(@RequestBody AppointmentDTO dto) {
		try {
			final AppointmentEntity entity = new AppointmentEntity();
			entity.setClinic(dto.getClinic());
			entity.setDate(dto.getDate());
			entity.setTypeAppointment(dto.getTypeAppointment());
			entity.setTypeProcedure(dto.getTypeProcedure());
					
			appointmentService.save(entity);
		}	catch (CustomException custom) {
			throw new ResponseStatusException(422, custom.getMessage(), custom);
		}
		
		return new ResponseDTO(true);
	}
	
	@PostMapping("/message")
	@ResponseBody
	public ResponseDTO message(@RequestBody MessageDTO dto) {
		try {
			final MessageEntity entity = new MessageEntity();
			entity.setName(dto.getName());
			entity.setPhone(dto.getPhone());
			entity.setEmail(dto.getEmail());
			entity.setMessage(dto.getMessage());
			
			messageService.save(entity);
		}	catch (CustomException custom) {
			throw new ResponseStatusException(422, custom.getMessage(), custom);
		}
		
		return new ResponseDTO(true);
	}
	
}
