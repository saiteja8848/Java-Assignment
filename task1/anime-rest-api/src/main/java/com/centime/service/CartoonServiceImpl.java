package com.centime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centime.aspects.LogMethodParam;
import com.centime.repository.CartoonRepository;
import com.centime.utility.BuildHierachyList;
import com.centime.wso.CartoonResponseWSO;

@Service
public class CartoonServiceImpl implements CartoonService{

    @Autowired
    CartoonRepository cartoonRepository;
	
	@Override
	@LogMethodParam
	public Optional<CartoonResponseWSO> getCartoonCharacterById(int id) {
		if(!BuildHierachyList.isListDataExitsInCache());
					this.getAllCartoonCharacters();
		Optional<CartoonResponseWSO> cartoon= BuildHierachyList.convertEntityToWSO(id);
		return cartoon;
	}

	@Override
	@LogMethodParam
	public List<CartoonResponseWSO> getAllCartoonCharacters() {
		return BuildHierachyList.convertEntityListToWSO(cartoonRepository.findAll());
	}

}
