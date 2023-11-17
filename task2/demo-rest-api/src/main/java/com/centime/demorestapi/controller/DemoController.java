package com.centime.demorestapi.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centime.demorestapi.entity.RequestWSO;

@Validated
@RestController
@RequestMapping("/service-a")
public interface DemoController {
	@GetMapping("/service-status")
    public ResponseEntity<Map<String, String>> getServiceStatus();
    
	@PostMapping(value="/concat",consumes="application/json")
	public ResponseEntity<?> getConcatedStrings(@Valid @RequestBody RequestWSO requestWso);
}
