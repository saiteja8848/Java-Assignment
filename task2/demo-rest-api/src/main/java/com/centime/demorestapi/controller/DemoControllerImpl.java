package com.centime.demorestapi.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.centime.demorestapi.aspects.CustomException;
import com.centime.demorestapi.aspects.LogMethodParam;
import com.centime.demorestapi.entity.RequestWSO;
import com.centime.demorestapi.service.DemoService;

@RestController
public class DemoControllerImpl implements DemoController {

	@Autowired
	DemoService demoService;

	@Override
	@LogMethodParam
	public ResponseEntity<Map<String, String>> getServiceStatus() {
		Map<String,String> map = new HashMap<>();
		map.put("service-status", "Up");
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}

	@Override
	@LogMethodParam
	public ResponseEntity<?> getConcatedStrings(RequestWSO requestWso) {
		Optional<String> response = demoService.getConcatedStrings(requestWso);
		if(response.isEmpty())
		   throw new CustomException("Invalid Payload");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
