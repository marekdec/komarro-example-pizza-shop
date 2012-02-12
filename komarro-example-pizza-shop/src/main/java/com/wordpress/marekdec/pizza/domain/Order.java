package com.wordpress.marekdec.pizza.domain;

public class Order {

	private long id;
	private Pizza pizza;
	private Address address;

	public Pizza getPizza() {
		return pizza;
	}

	public Address getAddress() {
		return address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
