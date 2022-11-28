package com.narcissus.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narcissus.api.entity.AppointmentEntity;
import com.narcissus.api.repository.AppointmentRepository;
import com.narcissus.api.service.exception.CustomException;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public void save(AppointmentEntity appointment) throws CustomException {
		
		if (!isAppointmentExist(appointment)) {
			appointmentRepository.save(appointment);
		}
	}
	
	public Boolean isAppointmentExist(AppointmentEntity appointment) throws CustomException {
		
		final AppointmentEntity appointmentCheck = appointmentRepository.findByClinicAndDate(appointment.getClinic(), appointment.getDate());
		if (appointmentCheck != null) {
			throw new CustomException("Já existe esse agendamento cadastrado!!!");
		}
		
		
		return false;
	}
}
