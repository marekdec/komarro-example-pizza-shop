package com.wordpress.marekdec.pizza.service;

import org.joda.time.DateTime;

import com.wordpress.marekdec.pizza.domain.Pizza;

public interface PizzaService {

	DateTime whenWillBePizzaReady(long orderId);

	Pizza getByName();

}
