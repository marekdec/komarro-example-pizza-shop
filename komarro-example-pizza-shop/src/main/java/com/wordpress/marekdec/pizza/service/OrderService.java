package com.wordpress.marekdec.pizza.service;

import javax.inject.Inject;

import com.wordpress.marekdec.pizza.domain.Address;
import com.wordpress.marekdec.pizza.domain.Order;
import com.wordpress.marekdec.pizza.domain.Pizza;
import com.wordpress.marekdec.pizza.repository.OrderRepository;

public class OrderService {

	@Inject
	private OrderRepository orderRepository;

	@Inject
	private PizzaService pizzaService;

	public long placeOrder(String pizzaName, Address address) {
		Pizza pizza = pizzaService.getByName();

		if (pizza != null) {
			Order order = new Order();
			order.setAddress(address);
			order.setPizza(pizza);

			Order newOrder = orderRepository.save(order);

			return newOrder.getId();
		} else {
			throw new IllegalArgumentException("The pizza " + pizzaName
					+ " does not exist in the menu card");
		}
	}
}
