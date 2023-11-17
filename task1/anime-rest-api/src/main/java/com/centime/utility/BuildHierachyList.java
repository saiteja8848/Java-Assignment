package com.centime.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.centime.entity.Cartoon;
import com.centime.wso.CartoonResponseWSO;

public class BuildHierachyList {

	static Map<Integer, CartoonResponseWSO> CartoonResponseWSOCache;
	static Set<Integer> isChild;
	public static List<CartoonResponseWSO> convertEntityListToWSO(List<Cartoon> cartoonCharactersList) {
		 List<CartoonResponseWSO> cartoonResponseWSOList = new ArrayList<CartoonResponseWSO>();
		 for(Cartoon cartoon : cartoonCharactersList ) {
			 cartoonResponseWSOList.add(convertEntityToWSO(cartoon));
		 }
		 buildHierarchyTree(cartoonResponseWSOList);
		 return cartoonResponseWSOList.stream().filter(cartoon -> !cartoon.getSubclasses().isEmpty()&&!isChild.contains(cartoon.getId()))
					.collect(Collectors.toList());
	}
	
	public static Optional<CartoonResponseWSO> convertEntityToWSO(Integer Id) {
			if (CartoonResponseWSOCache != null && CartoonResponseWSOCache.get(Id) != null)
				return Optional.ofNullable(CartoonResponseWSOCache.get(Id));
		return Optional.empty();
	}
	
	public static CartoonResponseWSO  convertEntityToWSO(Cartoon cartoon) {
		CartoonResponseWSO cartoonResponseWSO = new CartoonResponseWSO();
		cartoonResponseWSO.setName(cartoon.getName());
		cartoonResponseWSO.setParentId(cartoon.getParentId());
		cartoonResponseWSO.setId(cartoon.getId());
		return cartoonResponseWSO;
	}
	
	public static boolean isListDataExitsInCache() {
		return CartoonResponseWSOCache!=null && !CartoonResponseWSOCache.isEmpty();
	}

	public static void buildHierarchyTree(List<CartoonResponseWSO> cartoonCharactersList) {
		CartoonResponseWSOCache = new HashMap<>();
		isChild = new HashSet<Integer>();
		for (CartoonResponseWSO character : cartoonCharactersList) {
			CartoonResponseWSOCache.put(character.getId(), character);
		}

		for (CartoonResponseWSO character : cartoonCharactersList) {
			Integer parentId = character.getParentId();
			if (parentId != null) {
				CartoonResponseWSO parent = CartoonResponseWSOCache.get(parentId);
				if (parent != null) {
				    isChild.add(character.getId());
					parent.getSubclasses().add(character);
				}
			}
		}
	}
}
