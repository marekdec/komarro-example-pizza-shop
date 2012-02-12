package com.wordpress.marekdec.pizza.domain;

public class Address {

	private final String street;
	private final String city;
	private final String zipcode;

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public Address(String street, String city, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

}
