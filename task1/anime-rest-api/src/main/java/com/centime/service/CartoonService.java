package com.centime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.centime.wso.CartoonResponseWSO;

@Service
public interface CartoonService {
	public Optional<CartoonResponseWSO> getCartoonCharacterById(int id);
	public List<CartoonResponseWSO> getAllCartoonCharacters();
}
