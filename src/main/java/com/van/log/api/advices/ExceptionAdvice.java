package com.van.log.api.advices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler
	public ResponseEntity<Map<String, String>> trataIllegalStateException(IllegalStateException illegalStateException) {

		String erro = illegalStateException.getMessage();

		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("erroNegocio", erro);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMap);
	}
	
}
