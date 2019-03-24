package com.weyinmi.isack.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldValidationErrorDetails {
	
	private String error_title;
	private int error_status;
	private String error_detail;
	private long error_timeStamp;
	private String error_path;
	private String error_developer_message;
	private Map<String, List<FieldValidationError>> errors = 
			new HashMap<String, List<FieldValidationError>>();
	public String getError_title() {
		return error_title;
	}
	public void setError_title(String error_title) {
		this.error_title = error_title;
	}
	public int getError_status() {
		return error_status;
	}
	public void setError_status(int error_status) {
		this.error_status = error_status;
	}
	public String getError_detail() {
		return error_detail;
	}
	public void setError_detail(String error_detail) {
		this.error_detail = error_detail;
	}
	public long getError_timeStamp() {
		return error_timeStamp;
	}
	public void setError_timeStamp(long error_timeStamp) {
		this.error_timeStamp = error_timeStamp;
	}
	public String getError_path() {
		return error_path;
	}
	public void setError_path(String error_path) {
		this.error_path = error_path;
	}
	public String getError_developer_message() {
		return error_developer_message;
	}
	public void setError_developer_message(String error_developer_message) {
		this.error_developer_message = error_developer_message;
	}
	public Map<String, List<FieldValidationError>> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, List<FieldValidationError>> errors) {
		this.errors = errors;
	}
	

}
