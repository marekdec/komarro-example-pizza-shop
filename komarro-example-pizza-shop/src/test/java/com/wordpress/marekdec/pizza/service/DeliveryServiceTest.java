package com.wordpress.marekdec.pizza.service;

import static com.googlecode.komarro.Komarro.given;
import static com.googlecode.komarro.Komarro.instanceForTesting;
import static org.fest.assertions.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Test;

import com.wordpress.marekdec.pizza.domain.Address;

public class DeliveryServiceTest {

	private final DeliveryService deliveryService = instanceForTesting(DeliveryService.class);

	@Test
	public void testTheDeliveryTimeIsProperlyCalculated() {
		// given
		int minutesToGetToGivenAddress = 17;
		given(int.class).isRequested().thenReturn(minutesToGetToGivenAddress);

		DateTime timeWhenPizzaWillBeReady = new DateTime().withDate(2012, 12,
				21).withTime(13, 31, 0, 0);
		given(DateTime.class).isRequested()
				.thenReturn(timeWhenPizzaWillBeReady);

		// when
		DateTime deliveryTime = deliveryService.getEstimatedTimeOfDeliveryTo(
				1234L, deliveryAddress());

		// then
		assertThat(deliveryTime).isNotNull().isEqualTo(
				new DateTime().withDate(2012, 12, 21).withTime(13, 48, 0, 0));
	}

	private Address deliveryAddress() {
		return new Address("El Colegio Road 12", "Isla Vista", "93117");
	}
}
