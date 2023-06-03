package com.hourng.learning.java.phoneshop.exception;

import org.springframework.http.HttpStatus;

public class ResurceNotFoundException extends ApiException{

	public ResurceNotFoundException(String resurceName,Integer id) {
		super(HttpStatus.NOT_FOUND,String.format("%s with id=% d not found",resurceName,id));
	}

}
