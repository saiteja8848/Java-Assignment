package com.centime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.centime.aspects.CustomException;
import com.centime.aspects.LogMethodParam;
import com.centime.service.CartoonService;
import com.centime.wso.CartoonResponseWSO;


@RestController
public class CartoonControllerImpl implements CartoonController {

	@Autowired
	CartoonService cartoonService;
	
	
	@Override
	@LogMethodParam
	public ResponseEntity<?> getCartoonCharacterById(int id) {
		if(cartoonService.getCartoonCharacterById(id).isEmpty()) {
	            throw new CustomException("Entity with ID " + id + " not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(cartoonService.getCartoonCharacterById(id).get());
	}

	@Override
	@LogMethodParam
	public ResponseEntity<List<CartoonResponseWSO>> getAllCartoonCharacters() {
		return ResponseEntity.status(HttpStatus.OK).body(cartoonService.getAllCartoonCharacters());
	}

}
