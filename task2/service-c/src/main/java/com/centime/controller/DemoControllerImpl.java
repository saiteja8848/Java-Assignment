package com.centime.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.centime.aspects.LogMethodParam;


@RestController
public class DemoControllerImpl implements DemoController {
	
	@LogMethodParam
	public ResponseEntity<Map<String, String>> echoRequest() {
		Map<String,String> map = new HashMap<>();
		map.put("message", "Hello");
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
}
