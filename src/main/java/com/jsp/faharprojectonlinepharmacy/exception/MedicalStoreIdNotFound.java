package com.jsp.faharprojectonlinepharmacy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MedicalStoreIdNotFound extends RuntimeException{
	private String message;

}
