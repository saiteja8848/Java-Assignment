package com.centime.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centime.wso.CartoonResponseWSO;

@RestController
@RequestMapping("/v1/cartoon")
@Validated
public interface CartoonController {

	@GetMapping("/{id}")
	public ResponseEntity<?> getCartoonCharacterById(@Valid @NotNull @Positive @PathVariable int id);

	@GetMapping("/list")
	public ResponseEntity<List<CartoonResponseWSO>> getAllCartoonCharacters();
	
}
