package com.wordpress.marekdec.pizza.service;

import org.joda.time.DateTime;

public interface PizzaService {

	DateTime whenWillBePizzaReady(long orderId);

}
