package com.jsp.faharprojectonlinepharmacy.exception;

import lombok.AllArgsConstructor;

import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminPhoneNumberNotValidException extends RuntimeException{

	private String message;
}
