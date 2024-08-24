package com.jsp.faharprojectonlinepharmacy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminIdNotFoundException extends RuntimeException{
	private String message;

}
