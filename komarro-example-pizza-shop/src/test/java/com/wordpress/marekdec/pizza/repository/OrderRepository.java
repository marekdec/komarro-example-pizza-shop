package com.wordpress.marekdec.pizza.repository;

import com.wordpress.marekdec.pizza.domain.Order;

public interface OrderRepository {

	Order save(Order order);
}
