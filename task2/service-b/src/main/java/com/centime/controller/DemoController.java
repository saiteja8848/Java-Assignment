package com.centime.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centime.entity.RequestWSO;

@Validated
@RestController
@RequestMapping("/service-b")
public interface DemoController {
	@PostMapping(value="/concat",consumes="application/json")
	public ResponseEntity<String> concatNameAndSurname(@Valid @RequestBody RequestWSO requestWso);
}
