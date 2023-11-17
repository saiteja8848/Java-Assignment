package com.centime.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.centime.aspects.CustomException;
import com.centime.aspects.LogMethodParam;
import com.centime.entity.RequestWSO;

@RestController
public class DemoControllerImpl implements DemoController {

	@Override
	@LogMethodParam
	public ResponseEntity<String> concatNameAndSurname(RequestWSO requestWso) {
		if(requestWso==null || requestWso.getName()==null || requestWso.getSurname()==null)
			throw new CustomException("Invalid payload:requestWSO");
		return ResponseEntity.status(HttpStatus.OK).body(requestWso.getName()+" "+ requestWso.getSurname());
	}

}
