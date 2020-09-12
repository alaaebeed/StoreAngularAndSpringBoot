package com.alaa.product.exception;

public class IdException extends Exception {
	
	Long id ;

	public IdException(Long id) {

        super(String.format("Book is not found with id : '%s'", id));
	}
	
	

}
