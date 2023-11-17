package com.centime.wso;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class CartoonResponseWSO {
    @JsonIgnore
	int id;
    
    @JsonIgnore
	int parentId;
    
	@JsonIgnore
	String color;

	String name;
     
	@JsonInclude(value=Include.NON_EMPTY)
	@Transient
	private List<CartoonResponseWSO> subclasses = new ArrayList<CartoonResponseWSO>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String characterName) {
		this.name = characterName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<CartoonResponseWSO> getSubclasses() {
		return subclasses;
	}

	public void setSubclasses(List<CartoonResponseWSO> subclasses) {
		this.subclasses = subclasses;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CartoonResponseWSO [id=");
		builder.append(id);
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append(", color=");
		builder.append(color);
		builder.append(", name=");
		builder.append(name);
		builder.append(", subclasses=");
		builder.append(subclasses);
		builder.append("]");
		return builder.toString();
	}
}
