package com.centime.entity;

import javax.validation.constraints.NotNull;

public class RequestWSO {
	@NotNull(message = "name field cannot be null")
	String name;

	@NotNull(message = "name field cannot be null")
	String surname;

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestWSO [name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append("]");
		return builder.toString();
	}
}
