package com.wordpress.marekdec.pizza.service;

import javax.inject.Inject;

import org.joda.time.DateTime;

import com.wordpress.marekdec.pizza.domain.Address;

public class DeliveryService {

	@Inject
	private PizzaService pizzaService;

	@Inject
	private MapService mapService;

	public DateTime getEstimatedTimeOfDeliveryTo(long orderId, Address address) {
		DateTime timeWhenPizzaIsReady = pizzaService
				.whenWillBePizzaReady(orderId);

		int minutesToGetToGivenAddress = mapService.getTimeFromHereTo(address);
		return timeWhenPizzaIsReady.plusMinutes(minutesToGetToGivenAddress);
	}
}
