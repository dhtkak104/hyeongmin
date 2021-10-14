package com.mvc2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler({ Exception.class })
    public ResponseEntity<?> handleAll(final Exception e) {
		e.printStackTrace();
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.valueOf(500));
    }
	
}