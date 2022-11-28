package com.narcissus.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_appointment")
public class AppointmentEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="type_procedure")
	private String typeProcedure;
	
	@Column(name="type_appoinntment")
	private String typeAppointment;
	
	@Column(name="date")
	private String date;
	
	@Column(name="clinic")
	private String clinic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeProcedure() {
		return typeProcedure;
	}

	public void setTypeProcedure(String typeProcedure) {
		this.typeProcedure = typeProcedure;
	}

	public String getTypeAppointment() {
		return typeAppointment;
	}

	public void setTypeAppointment(String typeAppointment) {
		this.typeAppointment = typeAppointment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClinic() {
		return clinic;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

}
