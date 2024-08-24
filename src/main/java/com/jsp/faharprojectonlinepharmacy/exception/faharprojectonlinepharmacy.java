package com.jsp.faharprojectonlinepharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.faharprojectonlinepharmacy.util.ResponseStructure;

import ch.qos.logback.core.joran.action.NewRuleAction;

@RestControllerAdvice
public class faharprojectonlinepharmacy  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminIdNotFound(AdminIdNotFoundException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("invlid admin id");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleEmailNotFound(AdminEmailNotFoundException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("eamil is inValid");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleNumberNOtFoundException(AdminPhoneNumberNotValidException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("number not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAddressIdNOTFound(AddressIdNotFoundException e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("invlid admin id");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleStoreIdNotFound(MedicalStoreIdNotFound e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("store id not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
		
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleStaffIdNotFound(StaffIdNotFound e)
	{
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage("store id not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(e.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
		
	}

}
