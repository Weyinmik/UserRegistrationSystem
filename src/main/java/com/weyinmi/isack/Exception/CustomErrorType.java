package com.weyinmi.isack.Exception;

import com.weyinmi.isack.dto.UsersDTO;

public class CustomErrorType extends UsersDTO {
	private String errorMessage;
	
	public CustomErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

}
