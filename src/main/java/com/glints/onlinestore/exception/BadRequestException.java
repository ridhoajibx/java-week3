package com.glints.onlinestore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5424469867023235499L;
	
	String message;
	
	@JsonIgnore
	String trace;
    
    public BadRequestException () {
    }
    
    public BadRequestException (String message) {
        super(message);
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}

