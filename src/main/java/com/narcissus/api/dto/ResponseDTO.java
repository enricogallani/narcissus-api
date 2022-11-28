package com.narcissus.api.dto;

public class ResponseDTO {
	
	public ResponseDTO(Boolean success) {
		this.success = success;
	}
	
	private Boolean success;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
}
