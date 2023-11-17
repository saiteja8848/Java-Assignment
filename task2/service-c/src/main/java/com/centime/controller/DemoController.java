package com.centime.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-c")
public interface DemoController {
	@GetMapping("/hello")
	public ResponseEntity<Map<String, String>> echoRequest();
}
