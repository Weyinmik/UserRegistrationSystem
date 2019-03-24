package com.weyinmi.isack.Exception;

import java.util.List;
import java.util.Locale;
import java.awt.TrayIcon.MessageType;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestValidationHandler {
	
	private MessageSource messageSource;

	//	method to handle validation error
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<FieldValidationErrorDetails> handleValidationError(
			MethodArgumentNotValidException mNotValidException, HttpServletRequest request) {
		FieldValidationErrorDetails fErrorDetails = new FieldValidationErrorDetails();
		
		fErrorDetails.setError_timeStamp(new Date().getTime());
		fErrorDetails.setError_status(HttpStatus.BAD_REQUEST.value());
		fErrorDetails.setError_title("Field VAlidation Error");
		fErrorDetails.setError_detail("Input Field VAlidation Failed");
		fErrorDetails.setError_developer_message(mNotValidException.getClass().getName());
		fErrorDetails.setError_path(request.getRequestURI());
		
		BindingResult result = mNotValidException.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		
		for(FieldError error : fieldErrors) {
			FieldValidationError fError = processFieldError(error);
			List<FieldValidationError> fValidationErrorsList =
					fErrorDetails.getErrors().get(error.getField());
			if(fValidationErrorsList == null) {
				fValidationErrorsList = new ArrayList<FieldValidationError>();
			}
			fValidationErrorsList.add(fError);
			fErrorDetails.getErrors().put(error.getField(), fValidationErrorsList);
		}
		return new ResponseEntity<FieldValidationErrorDetails>(
				fErrorDetails, HttpStatus.BAD_REQUEST);
		
	}

	// method to process field error
	private FieldValidationError processFieldError(final FieldError error) {
		FieldValidationError fieldValidationError = new FieldValidationError();
		
		if(error != null) {
			// To be able to read the messages.properties file
			Locale currentLocale = LocaleContextHolder.getLocale();
			String msg = messageSource.getMessage(
					error.getDefaultMessage(), null, currentLocale);
			fieldValidationError.setField(error.getField());
			fieldValidationError.setType(MessageType.ERROR);
			fieldValidationError.setMessage(error.getDefaultMessage());
		}
		return fieldValidationError;
	}
}
