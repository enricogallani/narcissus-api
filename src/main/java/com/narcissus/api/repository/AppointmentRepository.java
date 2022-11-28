package com.narcissus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.narcissus.api.entity.AppointmentEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long>  {
	
	@Query("SELECT a FROM tb_appointment a WHERE a.clinic = :clinic and a.date = :date")
	AppointmentEntity findByClinicAndDate(
		@Param("clinic") String clinic, 
		@Param("date") String date
	);
	
}
