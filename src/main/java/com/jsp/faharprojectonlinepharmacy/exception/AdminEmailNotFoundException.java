package com.jsp.faharprojectonlinepharmacy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminEmailNotFoundException extends RuntimeException{
	private String message;
}
